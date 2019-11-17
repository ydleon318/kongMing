package di.yang.service.impl.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import di.yang.Dao.api.apiSingleTestDao;
import di.yang.service.apiService.apiSingleTestService;
import di.yang.module.api.apiSingleTest;
import di.yang.utils.BetterHttpClient;
import di.yang.utils.HttpUtil;
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
    public List<apiSingleTest> getApiSingleTestInfo(apiSingleTest apiSingle) {
        List<apiSingleTest> api = apisingleDao.getApiSingleTestInfo(apiSingle);
        return api;
    }

    /**
     *执行单条测试用例
     */
    @Override
    public boolean executeOneCase(JSONObject json) {
        JSONArray jsonArray = JSON.parseArray(json.getJSONArray("data").toString());
        for (Object obj : jsonArray) {
            JSONObject param = (JSONObject) obj;
            switch (param.getString("apimethod")){
                case "GET":
                    HttpUtil.get(param.getString("apiurl"));
                    if (HttpUtil.statuscode.equals(param.getString("apiresult"))){
                        apisingletest.setApistatus(true);
                        apisingletest.setApiresponse(HttpUtil.responseStr);
                    }else {
                        apisingletest.setApistatus(false);
                        apisingletest.setApiresponse(HttpUtil.responseStr);
                    }
                    break;
                    
            }


            param.get("apiparamvalue");
        }
        return false;
    }
}
