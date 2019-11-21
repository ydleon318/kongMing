import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

public class ResponseJsonDemo {
    private String str = "{\"data\":{\"step1\":\"one\"},\"data2\":\"step2\"}";

    @Test
    public void test01(){
//        JSONObject jsonObject = JSON.parseObject(str);
//        JSONObject data = jsonObject.getJSONObject("data");
//        Object step1 = data.get("step1");


        System.out.printf(String.valueOf(JSON.parseObject(str).get("data2")));
        System.out.printf(String.valueOf(JSON.parseObject(str).getJSONObject("data").get("step1")));
    }
}
