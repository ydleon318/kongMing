package di.yang.modle.api;

import lombok.Data;
import java.util.Date;

@Data
public class apiProcessStep {
    private int id;
    private String apiname;
    private String apiurl;
    private String apistep;
    private String apiparamvalue;
    private String apimethod;
    private String apiresult;
    private String apiresponse;
    private boolean apistatus;
    private Date createTime;
    private int apitestId;
}