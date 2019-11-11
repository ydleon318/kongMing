package di.yang.controllerService.impl;

import com.alibaba.fastjson.JSONObject;
import di.yang.controllerService.excuteRunPi;
import di.yang.getData.BankOrg;
import di.yang.getData.BatchDate;
import di.yang.modle.updateBatchDateVo;
import di.yang.utils.BetterHttpClient;
import di.yang.utils.MyWebDriver;
import di.yang.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Repository
public class excuteRunPiImpl implements excuteRunPi {
    private static final Logger log = LoggerFactory.getLogger(excuteRunPiImpl.class);
    @Autowired
    private BatchDate batchDate;

    @Autowired
    private BankOrg bankOrg;

    @Autowired
    private MyWebDriver driver;

    @Autowired
    private BetterHttpClient httpClient;

    @Override
    public boolean updateDB(updateBatchDateVo updateBatchDateVo, String workDate, String environment) {
        boolean flagBankOrg = bankOrg.updateWorkDate(workDate,environment);
        boolean flagBatchDate = batchDate.updateBatchDate(updateBatchDateVo,environment);
        boolean flag = false;
        if (flagBankOrg&&flagBatchDate){
            Tools.step("数据库修改成功");
            flag = true;
        }else {
            Tools.error("数据库修改失败");
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean excuteUI(String str) {
        boolean flag = false;
        try{
            driver.setDriver("firefox_linux");
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
                        driver.click("//*[@id='linshi']");
            }else{
                driver.click("//input[@type='button'][@value='下一页']");
                driver.click("//*[@id='usersList']/descendant::td[text()='"+str+"']/parent::tr/descendant::a[text()='任务操作']");
                driver.click("//*[@id='linshi']");
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

    @Override
    public boolean executArrivalNotice(String urlIp, JSONObject param) {
        try {
            httpClient.doPostWithJson("http://"+urlIp+"/testMq/qd",param);
            log.info("executArrivalNotice param is ----->{}",param);
            log.info("executArrivalNotice result is ----->{}",BetterHttpClient.responseStr);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
