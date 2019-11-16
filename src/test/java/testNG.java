

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import di.yang.service.impl.singleApiCasesServiceImpl;
import di.yang.service.singleApiCasesService;
import di.yang.enumList.DataSourceEnvironment;
import di.yang.Dao.TaskCases;
import di.yang.Dao.impl.TaskCasesImpl;
import di.yang.module.CasesVo;
import di.yang.test.demo;
import di.yang.utils.MyWebDriver;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.List;

public class testNG {
    private  final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
    private  final String JSON_ARRAY_STR = "{\"taskId\":[{\"step\":\"3001\"},{\"step\":\"3003\"},{\"step\":\"1008\"}]}";
    singleApiCasesService service = new singleApiCasesServiceImpl();

    TaskCases taskCases = new TaskCasesImpl();

    private MyWebDriver driver = new MyWebDriver();

    CasesVo cases = new CasesVo();

    public void test() {
        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");
        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass(demo.class));
        test.setXmlClasses(classes);


        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }

    public  void testJSONStrToJSONArray(){
        JSONObject jsonobject = JSON.parseObject(JSON_ARRAY_STR);
        System.out.printf(jsonobject.toString());
        JSONArray jsonArray = JSON.parseArray(jsonobject.getJSONArray("taskId").toString());
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的
        //遍历方式1
//        int size = jsonArray.size();
//        for (int i = 0; i < size; i++){
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            System.out.println(jsonObject.getString("step"));
//        }

        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            excuteUI(jsonObject.getString("step"));
        }
    }

    public void testComplexJSONStrToJSONObject(){
//        System.out.println(COMPLEX_JSON_STR);
        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的
//        System.out.println(jsonObject);
//        String teacherName = jsonObject.getString("teacherName");
//        Integer teacherAge = jsonObject.getInteger("teacherAge");
//        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");
        System.out.println("----json数组----"+students);
        JSONArray jsonArray = JSON.parseArray(students.toString());
        System.out.println(jsonArray);
    }

    public boolean excuteUI(String str) {
        boolean flag = false;
        try{
            driver.setDriver("firefox");
//            driver.setDriver("firefox");
            driver.open("http://172.16.131.136:8081/ucenter/index");
            driver.type("ucenter","//*[@id='loginname']");
            driver.type("a123456","//*[@id='password']");
            driver.click("//input[@type='button'][@value='登录']");
            driver.clickTextContains("核心账务系统");
            driver.selectWindow("首页");
            driver.clickTextContains("定时任务管理");
            if (driver.isTextPresent(str)){
                driver.click("//*[@id='usersList']/descendant::td[text()='"+str+"']/parent::tr/descendant::a[text()='任务操作']");
//                driver.click("//*[@id='linshi']");
            }else{
                driver.click("//input[@type='button'][@value='下一页']");
                driver.click("//*[@id='usersList']/descendant::td[text()='"+str+"']/parent::tr/descendant::a[text()='任务操作']");
//                driver.click("//*[@id='linshi']");
            }
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }finally {
            driver.closeURL();
        }
        return flag;
    }

    @Test
    public void get() {
        String msg = "172.16.131.6";
        DataSourceEnvironment environment = DataSourceEnvironment.getEnviron(msg);
        System.out.printf(environment.name());
    }
    @Test
    public void test01(){
        List<CasesVo> lists = new ArrayList<>();
        cases.setCaseId(10);
        cases.setDelFlag("0");
        cases.setExcutedFlag("0");
        lists = taskCases.selectCases(cases);
        System.out.printf(lists.toString());

    }

    @Test
    public void testNgtest(){
        test();

    }

    @Test
    public void testJsonArray(){
        testJSONStrToJSONArray();
//        testComplexJSONStrToJSONObject();
    }

}









