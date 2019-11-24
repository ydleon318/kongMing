package di.yang.service.impl.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.Dao.api.ApiProcessStepDao;
import di.yang.VO.AutoReplaceValueVo;
import di.yang.module.api.apiProcessStep;
import di.yang.service.apiService.ApiProcessStepService;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class ApiProcessStepServiceImpl implements ApiProcessStepService {

    @Autowired
    private ApiProcessStepDao apiProcessStepDao;
//    @Autowired
//    private apiProcessStep apistep;

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
        return new JSONObject(requestMap);
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
        Map<String, Object> key2Map=JSON.parseObject(String.valueOf(requestMap.get(key2)), HashMap.class);
        key2Map.put(key3,value);
        key1Map.put(key2,String.valueOf(new JSONObject(key2Map)));
        requestMap.put(key1,String.valueOf(new JSONObject(key1Map)));
        return new JSONObject(requestMap);
    }

    public boolean autoReplaceValue(JSONObject param){
        boolean flag = false;
        AutoReplaceValueVo autoReplaceValueVo = JSON.toJavaObject(param,AutoReplaceValueVo.class);
        List<apiProcessStep> apistep = apiProcessStepDao.selectApiProcessStepByProductId(autoReplaceValueVo.getApitestId());
            switch (apistep.get(autoReplaceValueVo.getRequestReplaceStep()).getRequestLevel()){
                case 1:
                    switch (apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getReponseLevel()){
                        case 1:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelOne(apistep.get(autoReplaceValueVo.getRequestReplaceStep())
                                    .getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep())
                                    .getRequestKey1(),responseLevelOne(apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getReponseKey1()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 2:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelOne(apistep.get(autoReplaceValueVo.getRequestReplaceStep()).getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep())
                                    .getRequestKey1(),responseLevelTwo(apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getApiresponse(),
                                    apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getReponseKey1(),apistep.get(autoReplaceValueVo.getResponseReplaceStep())
                                            .getReponseKey2()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        case 3:
                            autoReplaceValueVo.setApiparamvalue(String.valueOf(requestLevelOne(apistep.get(autoReplaceValueVo.getRequestReplaceStep()).getApiparamvalue(),apistep.get(autoReplaceValueVo.getRequestReplaceStep())
                                    .getRequestKey1(),responseLevelThree(apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getApiresponse()
                                    ,apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getReponseKey1(),apistep.get(autoReplaceValueVo.getResponseReplaceStep())
                                            .getReponseKey2(),apistep.get(autoReplaceValueVo.getResponseReplaceStep()).getReponseKey3()))));
                            flag = apiProcessStepDao.updataApiProcessStepRequest(autoReplaceValueVo);
                            break;
                        default:
                            flag = false;
                            Tools.error("数据错误");
                    }
                    
            }


        return flag;
    }

}