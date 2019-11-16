package di.yang.module;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Data
@Repository
public class CasesVo {
    private int caseId;
    private String apiName;
    private String productName;
    private String tester;
    private String url;
    private String method;
    private Date createTime;
    private Date updateTime;
    private String requestParams;
    private String delFlag;
    private String excutedFlag;
}
