

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.Dao.impl.apiImpl.ApiProcessStepDaoImpl;
import di.yang.module.api.apiProcessStep;
import org.apache.commons.lang3.StringEscapeUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseJsonDemo {
    private String str = "{\"data\":{\"step1\":\"one\",\"step2\":{\"NO01\":2}},\"data2\":\"step2\"}";
    private String str2 = "{\"data\":\"true\",\"status\":0}";
    private String str3 = "{\"status\":1}";

    @Test
    public void test01(){
//        JSONObject jsonObject = JSON.parseObject(str);
//        JSONObject data = jsonObject.getJSONObject("data");
//        Object step1 = data.get("step1");


//        System.out.printf(String.valueOf(JSON.parseObject(str).get("data2")));
//        System.out.printf(String.valueOf(JSON.parseObject(str).getJSONObject("data").get("step1")));
    }


    @Test
    public void test02(){
        Map<String, Object> hashMap=JSON.parseObject(str, HashMap.class); //获取字符串response中的字段值


        hashMap.put("status",JSON.parseObject(str3, HashMap.class).get("status"));//将字符串请求参数中的字段值变更为response中的字段值

        JSONObject json = new JSONObject(hashMap);//转为json串

        System.out.printf(String.valueOf(hashMap)+"              ");
        System.out.printf(String.valueOf(json));


    }

    @Test
    public void test03(){
        //三层json解析
        Map<String, Object> hashMap=JSON.parseObject(str, HashMap.class);
        Map<String, Object> map=JSON.parseObject(String.valueOf(hashMap.get("data")), HashMap.class);
        Map<String, Object> map2 = JSON.parseObject(String.valueOf(map.get("step2")), HashMap.class);
//        map2.get("NO01");
        map2.put("NO01",0);

        map.put("step2",String.valueOf(new JSONObject(map2)));

        hashMap.put("data",String.valueOf(new JSONObject(map)));

        JSONObject json = new JSONObject(hashMap);
        System.out.printf(json+"       ");
        System.out.printf(String.valueOf(json.getJSONObject("data").getJSONObject("step2").get("NO01")));
//          JSONObject json = JSON.parseObject(str);
//        System.out.printf(String.valueOf(json.getJSONObject("data").getJSONObject("step2").get("NO01")));

    }
    @Test
    public void test04(){
        ApiProcessStepDaoImpl dao = new ApiProcessStepDaoImpl();
        List<apiProcessStep> apistep = dao.selectApiProcessStepByProductId(2);
        System.out.printf(String.valueOf(apistep.size()));
    }
}
