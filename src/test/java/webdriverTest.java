import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.service.impl.web.WebProcessStepServiceImpl;
import org.testng.annotations.Test;

import java.util.Map;


/**
 * Created by yangdi on 2019/12/8
 */
public class webdriverTest {
    WebProcessStepServiceImpl webProcessStepService = new WebProcessStepServiceImpl();

    @Test
    public void test01(){
        String str = webProcessStepService.getWebOptMethodInfo(1);
        for (Map.Entry<String, Object> entry : JSON.parseObject(str).entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
