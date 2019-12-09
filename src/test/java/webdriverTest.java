import di.yang.enumList.WebOptMethod;
import di.yang.utils.Tools;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangdi on 2019/12/8
 */
public class webdriverTest {

    @Test
    public void test01(){
        try {
            System.out.printf(String.valueOf(getAllEnumByClassName("WebOptMethod")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据枚举的字符串获取枚举的值
     *
     * @param className 包名+类名
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getAllEnumByClassName(String className) throws Exception {
        // 1.得到枚举类对象
        Class<Enum> clz = (Class<Enum>) Class.forName(className);
        // 2.得到所有枚举常量
        Object[] objects = clz.getEnumConstants();
//        Method getCode = clz.getMethod("getCode");
        Method getMessage = clz.getMethod("getMessage");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Object obj : objects) {
            map = new HashMap<String, Object>();
//            map.put("code", getCode.invoke(obj));
            map.put("message", getMessage.invoke(obj));
            list.add(map);
        }
        return list;
    }

}
