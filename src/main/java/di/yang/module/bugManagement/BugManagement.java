package di.yang.module.bugManagement;

import lombok.Data;
import java.util.Date;

@Data
public class BugManagement {
    private int id;
    private String bugname;
    private String bugdetail;
    private String bugstatus;
    private String buglevel;
    private String bugcreater;
    private String bugassign;
    private Date createTime;
    private int productId;
}
