package di.yang.VO;

import lombok.Data;

/**
 * Created by yangdi on 2019/11/24
 */
@Data
public class AutoReplaceValueVo {
    private int apitestId;
    private int apistep;
    private String apiparamvalue;
    private int requestReplaceStep;
    private int responseReplaceStep;
}
