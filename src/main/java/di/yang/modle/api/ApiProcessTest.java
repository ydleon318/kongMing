package di.yang.modle.api;

import lombok.Data;
import java.util.Date;

@Data
public class ApiProcessTest {
    private int id;
    private String apitestname;
    private String apitestdesc;
    private String apitester;
    private boolean apitestresult;
    private Date createTime;
    private int productId;
}
