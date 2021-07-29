package di.yang.controller;

import com.alibaba.fastjson.JSONObject;
import di.yang.utils.MyWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class testController extends BaseController{
    @Autowired
    MyWebDriver driver;

    @PostMapping(value = "/apiForTest")
    public ResponseEntity<?> apiForTest (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;

        if (param.getInteger("status")==1){
            result = buildSuccessResponse(true);
        }else {
            result = buildErrorResponse(false);
        }
        return result;
    }

    @PostMapping(value = "/testRemote")
    public void testHub(@RequestBody JSONObject param){
        driver.setRemoteDriver(param.getString("node"), param.getString("browserName"));
        driver.open("http://www.baidu.com");
        driver.closeURL();
    }

}
