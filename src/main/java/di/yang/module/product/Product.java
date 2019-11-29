package di.yang.module.product;

import di.yang.module.PageSet;
import lombok.Data;
import java.util.Date;

@Data
public class Product extends PageSet {
    private int id;
    private String productname;
    private String productdesc;
    private String producter;
    private Date createTime;
    private String delflag;
}
