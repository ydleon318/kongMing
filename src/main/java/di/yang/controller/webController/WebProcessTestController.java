package di.yang.controller.webController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.web.WebProcessTest;
import di.yang.service.webService.WebProcessTestService;
import di.yang.utils.JsonUtils;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangdi on 2019/12/6
 */
@RestController
@RequestMapping(value = "/webProcessTest")
public class WebProcessTestController extends BaseController {

    @Autowired
    WebProcessTestService webProcessTestService;

    @PostMapping(value = "/addWebProcessTestCase")
    public ResponseEntity<?> addWebProcessTestCase (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addWebProcessTestCase param is--->"+param);
        WebProcessTest webProcessTest = JSON.toJavaObject(param,WebProcessTest.class);
        boolean flag = webProcessTestService.addWebProcessTestCase(webProcessTest);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("addWebProcessTestCase response is----->"+result);
        return result;
    }

    @PostMapping(value = "/updataWebProcessTestCase")
    public ResponseEntity<?> updataWebProcessTestCase (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("updataWebProcessTestCase param is--->"+param);
        WebProcessTest webProcessTest = JSON.toJavaObject(param,WebProcessTest.class);
        boolean flag = webProcessTestService.updataWebProcessTestCase(webProcessTest);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("updataWebProcessTestCase response is----->"+result);
        return result;
    }

    @PostMapping(value = "/selectWebProcessTestCase")
    public JSON selectWebProcessTestCase (@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectWebProcessTestCase param is--->"+param);
        WebProcessTest webProcessTest = JsonUtils.toObject(String.valueOf(param),WebProcessTest.class);
        reponse.put("data", JsonUtils.listWithDateToJson(webProcessTestService.selectWebProcessTestCase(webProcessTest), true));
        Tools.step("selectWebProcessTestCase response is--->"+reponse);
        return reponse;
    }
}
