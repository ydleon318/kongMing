package di.yang.controller.apiController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.modle.api.ApiSingleTest;
import di.yang.service.apiService.apiSingleTestService;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/excute")
public class apiSingleTestController extends BaseController {
//    private static Logger log = LoggerFactory.getLogger(apiSingleTestController.class.getName());
    @Autowired
    private apiSingleTestService apiservice;

    @PostMapping(value = "/addApiSingleCase")
    public ResponseEntity<?> addApiSingleCase(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("param is--->{}"+param);
        ApiSingleTest apiSingleTest = JSON.toJavaObject(param,ApiSingleTest.class);
        boolean flag = apiservice.addApiSingle(apiSingleTest);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        return result;
    }

    @PostMapping(value = "/updataApiSingleTestCase")
    public ResponseEntity<?> updataApiSingleTestCase (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("param is--->{}"+param);
        ApiSingleTest apiSingleTest = JSON.toJavaObject(param,ApiSingleTest.class);
        boolean flag = apiservice.updataApiSingleTest(apiSingleTest);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        return result;
    }

}
