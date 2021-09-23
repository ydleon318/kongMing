package di.yang.controller;

import com.alibaba.fastjson.JSONObject;
import di.yang.utils.MyWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class testController extends BaseController{
    private static Logger log = LoggerFactory.getLogger(singleApiCasesController.class.getName());
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

    /**
     * 微服务平台部署模块ui自动化
     * @param param browserName
     * @return
     */
    @PostMapping(value = "/testDeploy")
    public void testDeploy (@RequestBody JSONObject param){
        log.info("param is--->{}",param);
        driver.setDriver("chrome");
        driver.open("http://fat.web.msp.uat-bj.tech.sinotrans.com/msp/platform");
        driver.type("70073421","//*[@id='pane-first']/div/span/form/div[1]/div/div/input");
        driver.type("!234Qwer12345","//*[@id='pane-first']/div/span/form/div[2]/div/div/input");
        driver.click("//*[@id='pane-first']/div/span/button");

        driver.click("//span[text()='切换系统");
        driver.click("//input[@id='serviceInput']");
        driver.click("//*[@class='cell'][contains(text(),'外运股份公共服务技术平台微服务平台')]");
        driver.click("//span[text()='选 择']");
        //进入服务管理页面
        driver.click("//span[text()='服务管理'] ");
        driver.click("//span[text()='新增服务'] ");
        driver.type(param.getString("serviceName"),"//input[@placeholder='服务名称']");
        driver.type(param.getString("serviceCode"),"//input[@placeholder='服务编码']");
        driver.click("//span[text()='保存']");
        driver.click("//span[@class='item-title service-title'][text()='"+param.getString("serviceName")
                +"("+param.getString("serviceName")+")']");
        driver.click("//div[@id='tab-instanceList']");
        driver.click("//*[@class='el-icon-s-tools']");
        driver.click("//li[contains(text(),'配置文件')]");
        driver.click("//div[@class='view-line']");
        driver.inputKeyboard("server:");
        driver.pressEnter();
        driver.pressSpace();
        driver.pressSpace();
        driver.inputKeyboard("port:");
        driver.inputKeyboard(param.getString("port"));
        driver.click("//*[contains(text(),'发布 ')]");


        //进入部署页面
        driver.click("//span[@title='部署']");
        driver.pause(3);

        driver.click("//span[@class='item-title service-title'][text()='"+param.getString("serviceName")
                +"("+param.getString("serviceName")+")']");

        //向git地址中输入数据
        driver.type(param.getString("gitAdress"),
                "//*[@class='el-form-item__label']" +
                        "[contains(text(),'git地址')]/following-sibling::div[@class='el-form-item__content']" +
                        "/descendant::input");
        driver.click("//input[@placeholder='请选择应用类型']");
        driver.click("//span[text()='"+param.getString("applicationType")+"']");
        driver.click("//span[text()='保存']");

        driver.clickId("tab-second");
        driver.click("//label[@class='el-form-item__label'][contains(text(),'分支')]/following-sibling::div[@class='el-form-item__content']");
        driver.click("//span[text()='master']");
        driver.type("1.0.0","//*[contains(text(),'版本')]/following-sibling::div[@class='el-form-item__content']/descendant::input");
        driver.click("//span[text()='构建/部署']");
        driver.sleep(40);
        driver.click("//span[text()='刷新']");
        driver.pause(5);

        while (driver.getXpathText("//table[@class='el-table__body']/descendant::tr[1]/descendant::span").equals("执行中")){
            driver.pause(3);
            driver.click("//span[text()='刷新']");
            if (!driver.getXpathText("//table[@class='el-table__body']/descendant::tr[1]/descendant::span").equals("执行中")){
                break;
            }
        }
        log.info("部署"+driver.getXpathText("//table[@class='el-table__body']/descendant::tr[1]/descendant::span"));
        if (param.getInteger("isDel").equals(1)){
            driver.click("//span[text()='服务管理'] ");
            driver.click("//span[@class='item-title service-title'][text()='"+param.getString("serviceName")
                    +"("+param.getString("serviceName")+")']");
            driver.click("//span[text()='删除']");
            driver.click("//button[@class='el-button el-button--default el-button--small el-button--primary ']");
            log.info("服务删除成功");
        }
        driver.closeURL();
    }

    /**
     * 自动点赞
     * @param param
     */
    @PostMapping(value = "/typeFabulous")
    public void typeFabulous(@RequestBody JSONObject param){
        log.info("param is--->{}",param);
        driver.setDriver("chrome");
        driver.open("http://learningwx.hr.sinotrans.com/#/");
        driver.type(param.getString("userName"),"//input[@type='text']");
        driver.type(param.getString("passWorld"),"//input[@type='password']");
        driver.click("//a[@type='button']");
        driver.click("//*[contains(text(),'我的课程')]");
        driver.click("//a[@class='scopeClas'][1]/descendant::div[@class='detail box font-info']");
        driver.click("//button[@class='van-button van-button--default van-button--large van-dialog__confirm van-hairline--left']");

        for (int i =0; i<=param.getInteger("integral"); i++){
            if (param.getInteger("integral")>5000){
                break;
            }
            driver.sleepMillisecond(100);
            driver.click("//i[@class='fa fa-thumbs-up']");
        }
        driver.closeURL();
    }


}
