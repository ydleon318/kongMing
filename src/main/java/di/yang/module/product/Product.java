package di.yang.module.product;

import lombok.Data;
import java.util.Date;

@Data
public class Product {
    private int id;
    private String productname;
    private String productdesc;
    private String producter;
    private Date createTime;
    private String delflag;
}
