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

    /**
     * 执行接口业务流程测试用例
     * @param param {"apitestId":2,"isreplace":"Y","apiprocesstestId":1,"autoReplaceValue":{"apitestId":2,"responseReplaceStep":1,"requestReplaceStep":2,"apistep":2}}
     * @return boolean
     */
    boolean executeApiProcessSteps (JSONObject param);
}
