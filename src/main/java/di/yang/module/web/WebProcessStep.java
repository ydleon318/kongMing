package di.yang.module.web;

import di.yang.module.PageSet;
import lombok.Data;

/**
 * @Author yangdi
 * @Date 2019/12/6 11:29
 **/
@Data
public class WebProcessStep extends PageSet {
    private int id;
    private String webcasename;
    private String webteststep;
    private String webtestobjname;
    private String webfindmethod;
    private String webevelement;
    private String weboptmethod;
    private String webtestdata;
    private String webassertdata;
    private String webtestresult;
    private String createTime;
    private int webcaseId;
    private String screenShotPath;
}
