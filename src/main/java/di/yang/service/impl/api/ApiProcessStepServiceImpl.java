package di.yang.service.impl.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.Dao.api.ApiProcessStepDao;
import di.yang.Dao.api.apiProcessTestDao;
import di.yang.Dao.impl.apiImpl.ApiProcessStepDaoImpl;
import di.yang.VO.AutoReplaceValueVo;
import di.yang.module.api.apiProcessStep;
import di.yang.module.api.apiProcessTest;
import di.yang.service.apiService.ApiProcessStepService;
import di.yang.service.bugService.BugManageService;
import di.yang.utils.BetterHttpClient;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class ApiProcessStepServiceImpl implements ApiProcessStepService {

    @Autowired
    private BetterHttpClient httpClient;

    @Autowired
    private apiProcessStep apiprocessstep;
    @Autowired
    private apiProcessTest apiprocesstest;

    @Autowired
    private ApiProcessStepDao apiProcessStepDao;

    @Autowired
    private BugManageService bugManageService;
    @Autowired
    private apiProcessTestDao apiprocesstestdao;

    @Override
    public boolean addApiProcessStep(apiProcessStep apistep) {
        boolean flag = false;
        try{
            apiProcessStepDao.addApiProcessStep(apistep);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updataApiProcessStep(apiProcessStep apistep) {
        boolean flag = false;
                try{
                    apiProcessStepDao.updataApiProcessStep(apistep);
                    flag = true;
                }catch (Exception e){
                    e.printStackTrace();
                    flag = false;
                }
        return flag;
    }

    @Override
    public List<apiProcessStep> selectApiProcessStep(apiProcessStep apistep) {
        List<apiProcessStep> lists = apiProcessStepDao.selectApiProcessStepInfo(apistep);
        return lists;
    }

    /**
     * 返回response信息json层级为1的value值
     * @param response 获取的接口响应信息，表api_process_step中apiresponse字段
     * @param key 需要获取值的key
     * @return
     */
    public Object responseLevelOne(String response,Object key){
        return  JSON.parseObject(response).get(key);
    }

    /**
     * 返回response信息json层级为2的value值
     * @param response 获取的接口响应信息，表api_process_step中apiresponse字段
     * @param key1 需要获取值的第一层级key
     * @param key2 需要获取值的第二层级key
     * @return
     */
    public Object responseLevelTwo(String response,String key1,Object key2){
        return JSON.parseObject(response).getJSONObject(key1).get(key2);
    }

    /**
     * 返回response信息json层级为3的value值
     * @param response 获取的接口响应信息，表api_process_step中apiresponse字段
     * @param key1 需要获取值的第一层级key
     * @param key2 需要获取值的第二层级key
     * @param key3 需要获取值的第三层级key
     * @return
     */
    public Object responseLevelThree(String response,String key1,String key2,Object key3){
        return JSON.parseObject(response).getJSONObject(key1).getJSONObject(key2).get(key3);
    }

    /**
     * 替换请求参数中指定某一个字段值（json层级一）
     * @param request 接口请求参数
     * @param key 需要被替换的key
     * @param value 替换用的value值
     * @return
     */
    public Object requestLevelOne(String request,String key,Object value){
        Map<String, Object> requestMap= JSON.parseObject(request, HashMap.class);
        requestMap.put(key,value);
        return new JSONObject(requestMap);
    }

    /**
     * 替换请求参数中指定某一个字段值（json层级二）
     * @param request 接口请求参数
     * @param key1 json层级一的key
     * @param key2 json层级二的key（需要被替换值的key）
     * @param value 替换用的value值
     * @return
     */
    public Object requestLevelTwo(String request,String key1,String key2,Object value){
        Map<String, Object> requestMap= JSON.parseObject(request, HashMap.class);
        Map<String, Object> key1Map=JSON.parseObject(String.valueOf(requestMap.get(key1)), HashMap.class);
        key1Map.put(key2,value);
        requestMap.put(key1,String.valueOf(new JSONObject(key1Map)));
        return new JSONObject(requestMap).toJSONString().replace("\\","");
    }

    /**
     * 替换请求参数中指定某一个字段值（json层级三）
     * @param request 接口请求参数
     * @param key1 json层级一的key
     * @param key2 json层级二的key
     * @param key3 json层级三的key（需要被替换值的key）
     * @param value 替换用的value值
     * @return
     */
    public Object requestLevelThree(String request,String key1,String key2,String key3,Object value){
        Map<String, Object> requestMap= JSON.parseObject(request, HashMap.class);
        Map<String, Object> key1Map=JSON.parseObject(String.valueOf(requestMap.get(key1)), HashMap.class);
        Map<String, Object> key2Map=JSON.parseObject(String.valueOf(key1Map.get(key2)), HashMap.class);
        key2Map.put(key3,value);
        key1Map.put(key2,String.valueOf(new JSONObject(key2Map)));
        requestMap.put(key1,String.valueOf(new JSONObject(key1Map)));
        return new JSONObject(requestMap).toJSONString().replace("\\","");
    }

    /**
     * 自动将指定response中字段value值替换指定request中字段value值（支持大部分产品json格式接口自动化测试）
     * @param param {"apitestId":,"apistep":,"requestReplaceStep":,"responseReplaceStep":}
     * @return
     */
    @Override
    public boolean autoReplaceValue(JSONObject param){
        boolean flag = false;
        AutoReplaceValueVo autoReplaceValueVo = JSON.toJavaObject(param,AutoReplaceValueVo.class);
        List<apiProcessStep> apistep = apiProcessStepDao.selectApiProcessStepByProductId(autoReplaceValueVo.getApitestId());
            switch (apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getRequestLevel()){
                case 1:
                    switch (apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseLevel()){
                        case 1:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelOne(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),responseLevelOne(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 2:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelOne(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),responseLevelTwo(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                            .getReponseKey2()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 3:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelOne(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),responseLevelThree(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse()
                                    ,apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                            .getReponseKey2(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey3()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        default:
                            flag = false;
                            Tools.error("数据错误");
                    }
                    break;
                case 2:
                    switch (apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseLevel()){
                        case 1:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelTwo(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey2(),responseLevelOne(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 2:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelTwo(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey2(),responseLevelTwo(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                            .getReponseKey2()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 3:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelTwo(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey2(),responseLevelThree(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse()
                                    ,apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                            .getReponseKey2(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey3()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        default:
                            flag = false;
                            Tools.error("数据错误");
                    }
                    break;
                case 3:
                    switch (apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseLevel()){
                        case 1:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelThree(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey2(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey3(),responseLevelOne(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 2:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelThree(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey2(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey3(),responseLevelTwo(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                            .getReponseKey2()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 3:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelThree(apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey2(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                    .getRequestKey3(),responseLevelThree(apistep.get(autoReplaceValueVo.getResponseReplaceStep()-1).getApiresponse()
                                    ,apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey1(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1)
                                            .getReponseKey2(),apistep.get(autoReplaceValueVo.getRequestReplaceStep()-1).getReponseKey3()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        default:
                            flag = false;
                            Tools.error("数据错误");
                    }
                    break;
                default:
                    flag = false;
                    Tools.error("整体数据错误");
            }
        return flag;
    }

    /**
     * 执行接口业务流程测试用例
     * @param param {"apitestId":2,"isreplace":"Y","apiprocesstestId":1,"autoReplaceValue":{"apitestId":2,"responseReplaceStep":1,"requestReplaceStep":2,"apistep":2}}
     * @return
     * @throws IOException
     */
    public boolean executeApiProcessSteps(JSONObject param){
        boolean flag = false;
        try {
            List<apiProcessStep> apistep = apiProcessStepDao.selectApiProcessStepByProductId(param.getInteger("apitestId"));
            for (int i = 0; i < apistep.size(); i++) {
                if (param.getString("isreplace").equals("Y") && apistep.get(param.getJSONObject("autoReplaceValue").getInteger("responseReplaceStep") - 1).getApistatus() == 1) {
                    autoReplaceValue(param.getJSONObject("autoReplaceValue"));
                } else {
                    Tools.error("需要替换的response用例执行failed，无法替换，case： " + apistep.get(i).getId() + " 不执行");
                    continue;
                }
                if (apistep.get(i).getApimethod().equals("GET")) {
                    httpClient.doGet(apistep.get(i).getApiurl());
                    if (httpClient.codeStuts == 200 && httpClient.responseStr.equals(apistep.get(i).getApiresult())) {
                        apiprocessstep.setId(apistep.get(i).getId());
                        apiprocessstep.setApitestId(apistep.get(i).getApitestId());
                        apiprocessstep.setApistatus(1);
                        apiprocessstep.setApiresponse(httpClient.responseStr);
                        apiProcessStepDao.updataApiProcessStep(apiprocessstep);
                        Tools.step("case：" + apistep.get(i).getId() + " is PASS");
                    } else {
                        apiprocessstep.setId(apistep.get(i).getId());
                        apiprocessstep.setApitestId(apistep.get(i).getApitestId());
                        apiprocessstep.setApistatus(0);
                        apiprocessstep.setApiresponse(httpClient.responseStr);
                        apiProcessStepDao.updataApiProcessStep(apiprocessstep);
                        Tools.step("case： " + apistep.get(i).getId() + " is FAILED");
                        bugManageService.addBug(apistep.get(i).getApiname(), apistep.get(i).getApiparamvalue(), apistep.get(i).getApiresult()
                                , httpClient.responseStr, 4, "杨迪", "孟丹", apistep.get(i).getApitestId());
                    }
                } else if (apistep.get(i).getApimethod().equals("POST")) {
                    httpClient.doPostWithJson(apistep.get(i).getApiurl(), apistep.get(i).getApiparamvalue());
                    if (httpClient.codeStuts == 200 && httpClient.responseStr.equals(apistep.get(i).getApiresult())) {
                        apiprocessstep.setId(apistep.get(i).getId());
                        apiprocessstep.setApitestId(apistep.get(i).getApitestId());
                        apiprocessstep.setApistatus(1);
                        apiprocessstep.setApiresponse(httpClient.responseStr);
                        apiProcessStepDao.updataApiProcessStep(apiprocessstep);
                        Tools.step("case：" + apistep.get(i).getId() + " is PASS");
                    } else {
                        apiprocessstep.setId(apistep.get(i).getId());
                        apiprocessstep.setApitestId(apistep.get(i).getApitestId());
                        apiprocessstep.setApistatus(0);
                        apiprocessstep.setApiresponse(httpClient.responseStr);
                        apiProcessStepDao.updataApiProcessStep(apiprocessstep);
                        Tools.step("case： " + apistep.get(i).getId() + " is FAILED");
                        bugManageService.addBug(apistep.get(i).getApiname(), apistep.get(i).getApiparamvalue(), apistep.get(i).getApiresult()
                                , httpClient.responseStr, 4, "杨迪", "孟丹", apistep.get(i).getApitestId());
                    }
                } else {
                    Tools.error("需传入正确的请求类型");
                    continue;
                }
            }
            //回写apiprocesstest库动作
            List<apiProcessStep> status = apiProcessStepDao.selectApiProcessStepByProductId(param.getInteger("apitestId"));
            List<Integer> statuslist = new ArrayList<Integer>();
            for (int i = 0; i < status.size(); i++) {
                statuslist.add(status.get(i).getApistatus());
            }
            for (int j = 0; j < statuslist.size(); ) {
                if (j == statuslist.size()) {
                    apiprocesstest.setId(param.getInteger("apiprocesstestId"));
                    apiprocesstest.setProductId(param.getInteger("apitestId"));
                    apiprocesstest.setApitestresult(1);
                    apiprocesstestdao.updataApiProcessTest(apiprocesstest);
                    flag = true;
                    break;
                }
                if (statuslist.get(j) != 1) {
                    apiprocesstest.setId(param.getInteger("apiprocesstestId"));
                    apiprocesstest.setProductId(param.getInteger("apitestId"));
                    apiprocesstest.setApitestresult(0);
                    apiprocesstestdao.updataApiProcessTest(apiprocesstest);
                    flag = true;
                    break;
                } else {
                    j++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
