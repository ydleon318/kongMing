package di.yang.service.impl.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import di.yang.Dao.api.apiSingleTestDao;
import di.yang.service.apiService.apiSingleTestService;
import di.yang.module.api.apiSingleTest;
import di.yang.service.bugService.BugManageService;
import di.yang.utils.BetterHttpClient;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class apiSingleTestServiceImpl implements apiSingleTestService {
    @Autowired
    private apiSingleTestDao apisingleDao;

    @Autowired
    private BetterHttpClient httpClient;

    @Autowired
    private BugManageService bugManageService;


    @Override
    public boolean addApiSingle(apiSingleTest apiSingle) {
        boolean data = apisingleDao.addApiSingle(apiSingle);
        return data;
    }

    @Override
    public boolean updataApiSingleTest(apiSingleTest apiSingle) {
        boolean data = apisingleDao.updataApiSingleTest(apiSingle);
        return data;
    }

    @Override
    public List<apiSingleTest> getApiSingleTestInfo(apiSingleTest apiSingle){
        apiSingle.setPagenum((apiSingle.getPagenum()-1)*apiSingle.getPagesize());
        return apisingleDao.getApiSingleTestInfo(apiSingle);
    }

    /**
     *执行测试用例
     */
    @Override
    public boolean executeCases(JSONObject json) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(json);
        boolean flag = false;
        try {
            JSONArray jsonArray = JSON.parseArray(jsonObject.getJSONArray("data").toString());
            for (Object obj : jsonArray) {
                JSONObject param = (JSONObject) obj;
                apiSingleTest apisingletest = new apiSingleTest();
                apisingletest = apisingleDao.selectApiSingleTestByid(param.getInteger("id"));
                switch (apisingletest.getApimethod()) {
                    case "GET":
                        httpClient.doGet(apisingletest.getApiurl());
                        if (httpClient.responseStr.contains(apisingletest.getApiresult()) && httpClient.codeStuts==200) {
                            apiSingleTest api = new apiSingleTest();
                            api.setId(param.getInteger("id"));
                            api.setProductId(apisingletest.getProductId());
                            api.setApistatus(1);
                            api.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(api);
                            Tools.step("testcase NO "+param.getString("id")+" is PASS");
                        } else {
                            apiSingleTest api = new apiSingleTest();
                            api.setId(param.getInteger("id"));
                            api.setProductId(apisingletest.getProductId());
                            api.setApistatus(0);
                            api.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(api);
                            Tools.step("testcase NO "+param.getString("id")+" is FAILED");
                            bugManageService.addBug(apisingletest.getApiname(),apisingletest.getApiparamvalue(),apisingletest.getApiresult()
                            ,httpClient.responseStr,4,"杨迪","孟丹",apisingletest.getProductId());
                        }
                        break;
                    case "POST":
                        httpClient.doPostWithJson(apisingletest.getApiurl(),apisingletest.getApiparamvalue());
                        if (httpClient.responseStr.contains(apisingletest.getApiresult()) && httpClient.codeStuts==200) {
                            apiSingleTest api = new apiSingleTest();
                            api.setId(param.getInteger("id"));
                            api.setProductId(apisingletest.getProductId());
                            api.setApistatus(1);
                            api.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(api);
                            Tools.step("testcase NO "+param.getString("id")+" is PASS");
                        } else {
                            apiSingleTest api = new apiSingleTest();
                            api.setId(param.getInteger("id"));
                            api.setProductId(apisingletest.getProductId());
                            api.setApistatus(0);
                            api.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(api);
                            Tools.step("testcase NO "+param.getString("id")+" is FAILED");
                            bugManageService.addBug(apisingletest.getApiname(),apisingletest.getApiparamvalue(),apisingletest.getApiresult()
                                    ,httpClient.responseStr,4,"杨迪","孟丹",apisingletest.getProductId());
                        }
                        break;
                    default:
                        Tools.error("未知错误");
                }
            }
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
