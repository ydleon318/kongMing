package di.yang.modle.api;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class ApiSingleTest {
    private int id;
    private String apiname;
    private String apiurl;
    private String apiparamvalue;
    private String apimethod;
    private String apiresult;
    private String apiresponse;
    private boolean apistatus;
    private Date createTime;
    private int productId;
}
