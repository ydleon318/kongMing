package di.yang.controller.apiController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.api.apiProcessTest;
import di.yang.service.apiService.apiProcessTestService;
import di.yang.utils.JsonUtils;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apiProcessTest")
public class ApiProcessTestController extends BaseController {
    @Autowired
    private apiProcessTestService apiprocesstestservice;

    @PostMapping(value = "/addApiProcessTest")
    public ResponseEntity<?> addApiProcessTest (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addApiProcessTest param is--->"+param);
        apiProcessTest apiprocesstest = JSON.toJavaObject(param, apiProcessTest.class);
        boolean data = apiprocesstestservice.addApiProcessTest(apiprocesstest);
        if (data){
            result = buildSuccessResponse(data);
        }else {
            result = buildErrorResponse(data);
        }
        Tools.step("addApiProcessTestResponse is----->"+result);
        return result;
    }

    @PostMapping(value = "/updataApiProcessTest")
    public ResponseEntity<?> updataApiProcessTest (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("updataApiProcessTest param is--->"+param);
        apiProcessTest apiprocesstest = JSON.toJavaObject(param,apiProcessTest.class);
        boolean data = apiprocesstestservice.updataApiProcessTest(apiprocesstest);
        if (data){
            result = buildSuccessResponse(data);
        }else {
            result = buildErrorResponse(data);
        }
        Tools.step("updataApiProcessTestResponse is----->"+result);
        return result;
    }

    @PostMapping(value = "/selectApiProcessTestInfo")
    public JSON selectApiProcessTestInfo (@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectApiProcessTestInfo param is--->"+param);
        apiProcessTest apiprocesstest = JsonUtils.toObject(String.valueOf(param),apiProcessTest.class);
        reponse.put("data", JsonUtils.listWithDateToJson(apiprocesstestservice.selectApiProcessTest(apiprocesstest), true));
        Tools.step("selectApiProcessTestInfo response is--->"+reponse);
        return reponse;
    }
}
