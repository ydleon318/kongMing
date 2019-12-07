package di.yang.controller.apiController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.api.apiProcessStep;
import di.yang.service.apiService.ApiProcessStepService;
import di.yang.utils.JsonUtils;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangdi on 2019/11/23
 */
@RestController
@RequestMapping(value = "/apiProcessStep")
public class ApiProcessStepController extends BaseController {

    @Autowired
    public ApiProcessStepService apiProcessStepService;

    @PostMapping(value = "/addApiProcessStep")
    public ResponseEntity<?> addApiProcessStep(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addApiProcessStep param is--->"+param);
        apiProcessStep apistep = JSON.toJavaObject(param,apiProcessStep.class);
        boolean flag = apiProcessStepService.addApiProcessStep(apistep);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("addApiProcessStep response is----->"+result);
        return result;
    }

    @PostMapping(value = "/updataApiProcessStep")
    public ResponseEntity<?> updataApiProcessStep(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("updataApiProcessStep param is--->"+param);
        apiProcessStep apistep = JSON.toJavaObject(param,apiProcessStep.class);
        boolean flag = apiProcessStepService.updataApiProcessStep(apistep);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("updataApiProcessStep response is----->"+result);
        return result;
    }

    @PostMapping(value = "/selectApiProcessStep")
    public JSON selectApiProcessStep(@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectApiProcessStep param is--->"+param);
        apiProcessStep apistep = JsonUtils.toObject(String.valueOf(param),apiProcessStep.class);
        reponse.put("data", JsonUtils.listWithDateToJson(apiProcessStepService.selectApiProcessStep(apistep), true));
        Tools.step("selectApiProcessStep response is--->"+reponse);
        return reponse;
    }

    @PostMapping(value = "/executeApiProcessSteps")
    public ResponseEntity<?> executeApiProcessSteps(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("executeApiProcessSteps param is--->"+param);
        boolean flag = apiProcessStepService.executeApiProcessSteps(param);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("executeApiProcessSteps response is----->"+result);
        return  result;
    }

}
