package di.yang.module;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class updateBatchDateVo {
    private String batchDate;
    private String channelNo;

}
