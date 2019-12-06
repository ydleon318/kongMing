package di.yang.module.web;

import di.yang.module.PageSet;
import lombok.Data;

/**
 * @Author yangdi
 * @Date 2019/12/6 13:20
 **/
@Data
public class WebProcessTest extends PageSet{
    private int id;
    private String webcasename;
    private boolean webtestresult;
    private String webtester;
    private String createTime;
    private String productId;
    private String delflag;
}
