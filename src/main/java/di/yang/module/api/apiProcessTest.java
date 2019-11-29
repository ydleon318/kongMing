package di.yang.module.api;


import di.yang.module.PageSet;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class apiProcessTest extends PageSet {
    private int id;
    private String apitestname;
    private String apitestdesc;
    private String apitester;
    private int apitestresult;
    private Date createTime;
    private int productId;
    private String delflag;
}
