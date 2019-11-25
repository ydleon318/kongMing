package di.yang.service.apiService;

import com.alibaba.fastjson.JSONObject;
import di.yang.module.api.apiProcessStep;

import java.util.List;

public interface ApiProcessStepService {
    /**
     * 添加接口业务流程测试步骤
     * @param apistep
     * @return
     */
    boolean addApiProcessStep(apiProcessStep apistep);

    /**
     * 修改业务流程测试步骤
     * @param apistep
     * @return
     */
    boolean updataApiProcessStep(apiProcessStep apistep);

    /**
     * 查询业务流程测试步骤
     * @param apistep
     * @return
     */
    List<apiProcessStep> selectApiProcessStep(apiProcessStep apistep);

    /**
     * 自动将指定response中字段value值替换指定request中字段value值（支持大部分公司产品json格式接口自动化测试）
     * @param param
     * @return
     */
    boolean autoReplaceValue (JSONObject param);
}
