package di.yang.module.product;

import di.yang.module.PageSet;
import lombok.Data;
import java.util.Date;
/**
 * @Author yangdi
 * @Date 2019/11/6 13:20
 **/
@Data
public class Product extends PageSet {
    private int id;
    private String productname;
    private String productdesc;
    private String producter;
    private Date createTime;
    private String delflag;
}
