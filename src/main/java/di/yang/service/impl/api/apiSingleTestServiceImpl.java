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

    @Autowired
    private apiSingleTest apisingletest;

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
                switch (param.getString("apimethod")) {
                    case "GET":
                        httpClient.doGet(param.getString("apiurl"));
                        if (httpClient.responseStr.contains(param.getString("apiresult")) && httpClient.codeStuts==200) {
                            apisingletest.setId(param.getInteger("id"));
                            apisingletest.setProductId(param.getInteger("productId"));
                            apisingletest.setApistatus(1);
                            apisingletest.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(apisingletest);
                            Tools.step("testcase NO "+param.getString("id")+" is PASS");
                        } else {
                            apisingletest.setId(param.getInteger("id"));
                            apisingletest.setProductId(param.getInteger("productId"));
                            apisingletest.setApistatus(0);
                            apisingletest.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(apisingletest);
                            Tools.step("testcase NO "+param.getString("id")+" is FAILED");
                            bugManageService.addBug(param.getString("apiname"),param.getString("apiparamvalue"),param.getString("apiresult")
                            ,httpClient.responseStr,4,"杨迪","孟丹",param.getInteger("productId"));
                        }
                        break;
                    case "POST":
                        httpClient.doPostWithJson(param.getString("apiurl"),param.getString("apiparamvalue"));
                        if (httpClient.responseStr.contains(param.getString("apiresult")) && httpClient.codeStuts==200) {
                            apisingletest.setId(param.getInteger("id"));
                            apisingletest.setProductId(param.getInteger("productId"));
                            apisingletest.setApistatus(1);
                            apisingletest.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(apisingletest);
                            Tools.step("testcase NO "+param.getString("id")+" is PASS");
                        } else {
                            apisingletest.setId(param.getInteger("id"));
                            apisingletest.setProductId(param.getInteger("productId"));
                            apisingletest.setApistatus(0);
                            apisingletest.setApiresponse(httpClient.responseStr);
                            apisingleDao.updataApiSingleTestResult(apisingletest);
                            Tools.step("testcase NO "+param.getString("id")+" is FAILED");
                            bugManageService.addBug(param.getString("apiname"),param.getString("apiparamvalue"),param.getString("apiresult")
                                    ,httpClient.responseStr,4,"杨迪","孟丹",param.getInteger("productId"));
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
