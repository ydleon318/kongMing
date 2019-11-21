package di.yang.module.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private int apistatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private int apitestId;
}
