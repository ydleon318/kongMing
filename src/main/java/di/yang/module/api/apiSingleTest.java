package di.yang.module.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import di.yang.module.PageSet;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class apiSingleTest extends PageSet{
    private int id;
    private String apiname;
    private String apiurl;
    private String apiparamvalue;
    private String apimethod;
    private String apiresult;
    private String apiresponse;
    private int apistatus;
    private Date createTime;
    private int productId;
    private String delflag;
}
