package di.yang.module.api;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class apiProcessStep {
    private int id;
    private String apiname;
    private String apiurl;
    private int apistep;
    private String apiparamvalue;
    private String apimethod;
    private String apiresult;
    private String apiresponse;
    private int apistatus;
    private Date createTime;
    private int apitestId;
    private String isreplace;
    private int requestLevel;
    private int reponseLevel;
    private String requestKey1;
    private String requestKey2;
    private String requestKey3;
    private String reponseKey1;
    private String reponseKey2;
    private String reponseKey3;
    private String delflag;
}
