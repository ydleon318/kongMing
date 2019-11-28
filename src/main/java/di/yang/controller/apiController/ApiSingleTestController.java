package di.yang.controller.apiController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.api.apiSingleTest;
import di.yang.service.apiService.apiSingleTestService;
import di.yang.utils.JsonUtils;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/singleApi")
public class ApiSingleTestController extends BaseController {
    @Autowired
    private apiSingleTestService apiservice;

    @PostMapping(value = "/addApiSingleCase")
    public ResponseEntity<?> addApiSingleCase(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addApiSingleCase param is--->"+param);
        apiSingleTest apisingletest = JSON.toJavaObject(param, apiSingleTest.class);
        boolean flag = apiservice.addApiSingle(apisingletest);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("addApiSingleCase result is--->"+result);
        return result;
    }

    @PostMapping(value = "/updataApiSingleTestCase")
    public ResponseEntity<?> updataApiSingleTestCase (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("updataApiSingleTestCase param is--->"+param);
        apiSingleTest apisingletest = JSON.toJavaObject(param, apiSingleTest.class);
        boolean flag = apiservice.updataApiSingleTest(apisingletest);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("addApiSingleCase result is--->"+result);
        return result;
    }

    @PostMapping(value = "/selectApiSingleTest")
    public JSON selectApiSingleTest (@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectProudctData param is--->"+param);
        apiSingleTest apisingl = JsonUtils.toObject(String.valueOf(param),apiSingleTest.class);
        reponse.put("data", JsonUtils.listWithDateToJson(apiservice.getApiSingleTestInfo(apisingl), true));
        Tools.step("selectProudctData response is--->"+reponse);
        return reponse;
    }

    @PostMapping(value = ("/executeCases"))
    public ResponseEntity<?> executeCases (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("executeCases param is--->"+param);
        boolean flag = apiservice.executeCases(param);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("executeCases result is---->"+result);
        return result;
    }

}
