package di.yang.module.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class apiProcessTest {
    private int id;
    private String apitestname;
    private String apitestdesc;
    private String apitester;
    private int apitestresult;
    private Date createTime;
    private int productId;
}
