import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.service.impl.web.WebProcessStepServiceImpl;
import di.yang.utils.MyWebDriver;
import org.testng.annotations.Test;

import java.util.Map;


/**
 * Created by yangdi on 2019/12/8
 */
public class webdriverTest {
    MyWebDriver dr = new MyWebDriver();
    WebProcessStepServiceImpl webProcessStepService = new WebProcessStepServiceImpl();

//    @Test
//    public void test01(){
//        String str = webProcessStepService.getWebOptMethodInfo(1);
//        for (Map.Entry<String, Object> entry : JSON.parseObject(str).entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//    }
//    @Test
//    public void test02(){
//        MyWebDriver driver = new MyWebDriver();
//        driver.setRemoteDriver("http://localhost:5566/wd/hub","chrome");
//        driver.open("http://www.baidu.com");
//        driver.type("selenium","//*[@id=\"kw\"]");
//        driver.click("//*[@id=\"su\"]");
//        driver.closeURL();
//    }
//    @Test
    public void test03(){

        dr.setDriver("chrome");
        dr.open("http://fat.web.msp.uat-bj.tech.sinotrans.com/msp/platform");
        dr.type("70073421","//*[@id=\"pane-first\"]/div/span/form/div[1]/div/div/input");
        dr.type("!234Qwer12345","//*[@id=\"pane-first\"]/div/span/form/div[2]/div/div/input");
        dr.click("//*[@id=\"pane-first\"]/div/span/button");

        dr.click("//span[text()='切换系统']");
        dr.click("//input[@id='serviceInput']");
        dr.click("//*[@class='cell'][contains(text(),'外运股份公共服务技术平台微服务平台')]");
        dr.click("//span[text()='选 择']");

        dr.click("//span[text()='服务管理'] ");
        dr.click("//span[text()='新增服务'] ");
        dr.type("test02","//input[@placeholder='服务名称']");
        dr.type("test02","//input[@placeholder='服务编码']");
        dr.click("//span[text()='保存']");
        dr.click("//span[@class='item-title service-title'][text()='test02(test02)']");
        dr.click("//div[@id='tab-instanceList']");
        dr.click("//*[@class='el-icon-s-tools']");
        dr.click("//li[contains(text(),'配置文件')]");
        dr.click("//div[@class='view-line']");
        dr.inputKeyboard("server:");
        dr.pressEnter();
        dr.pressSpace();
        dr.pressSpace();
        dr.inputKeyboard("port:");
        dr.inputKeyboard("9028");
        dr.click("//*[contains(text(),'发布 ')]");


        dr.click("//span[@title='部署']");
        dr.pause(3);

        dr.click("//span[@class='item-title service-title'][text()='mydemo5(mydemo5)']");
        dr.clickId("tab-second");
        dr.click("//label[@class='el-form-item__label'][contains(text(),'分支')]/following-sibling::div[@class='el-form-item__content']");
        dr.click("//span[text()='master']");
        dr.type("1.0.0","//*[contains(text(),'版本')]/following-sibling::div[@class='el-form-item__content']/descendant::input");
        dr.click("//span[text()='构建/部署']");
        dr.pause(15);
        dr.click("//span[text()='刷新']");


        dr.closeURL();
    }

//    @Test
    public void test04(){
        dr.setDriver("chrome");
        dr.open("http://learningwx.hr.sinotrans.com/#/");
        dr.type("13681500164","//input[@type='text']");
        dr.type("Sinotr@ns123456","//input[@type='password']");
        dr.click("//a[@type='button']");
        dr.click("//*[contains(text(),'我的课程')]");
        dr.click("//a[@class='scopeClas'][1]/descendant::div[@class='detail box font-info']");

        dr.click("//button[@class='van-button van-button--default van-button--large van-dialog__confirm van-hairline--left']");
        dr.click("//i[@class='fa fa-thumbs-up']");
        dr.closeURL();
    }

}
