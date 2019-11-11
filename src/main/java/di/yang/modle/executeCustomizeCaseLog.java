package di.yang.modle;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class executeCustomizeCaseLog {
    private int caseId;
    private String executUrl;
    private String apiName;
    private String productName;
    private String tester;
    private String responseInfo;
    private int statusCode;
}
