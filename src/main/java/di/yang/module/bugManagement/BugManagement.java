package di.yang.module.bugManagement;

import di.yang.module.PageSet;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class BugManagement extends PageSet {
    private int id;
    private String bugname;
    private String bugdetail;
    private String bugstatus;
    private int buglevel;
    private String bugcreater;
    private String bugassign;
    private Date createTime;
    private int productId;
}
