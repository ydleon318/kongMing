package di.yang.controller.webController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.web.WebProcessStep;
import di.yang.service.webService.WebProcessStepService;
import di.yang.utils.JsonUtils;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangdi on 2019/12/8
 */
@RestController
@RequestMapping(value = "/webProcessStep")
public class WebProcessStepController extends BaseController {

    @Autowired
    private WebProcessStepService webProcessStepService;

    @PostMapping(value = "/addWebProcessStep")
    public ResponseEntity<?> addWebProcessStep(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addWebProcessStep param is--->"+param);
        WebProcessStep webstep = JSON.toJavaObject(param,WebProcessStep.class);
        boolean flag = webProcessStepService.addWebProcessStep(webstep);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("addWebProcessStep response is----->"+result);
        return result;
    }

    @PostMapping(value = "/updataWebProcessStep")
    public ResponseEntity<?> updataWebProcessStep(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addWebProcessStep param is--->"+param);
        WebProcessStep webstep = JSON.toJavaObject(param,WebProcessStep.class);
        boolean flag = webProcessStepService.updataWebProcessStep(webstep);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("updataWebProcessStep response is----->"+result);
        return result;
    }

    @PostMapping(value = "/selectWebProcessStep")
    public JSON selectWebProcessStep(@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectWebProcessStep param is--->"+param);
        WebProcessStep webstep = JsonUtils.toObject(String.valueOf(param),WebProcessStep.class);
        reponse.put("data", JsonUtils.listWithDateToJson(webProcessStepService.selectWebProcessStep(webstep), true));
        Tools.step("selectWebProcessStep response is--->"+reponse);
        return reponse;
    }

}
