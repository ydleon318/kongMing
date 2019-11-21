package di.yang.service.apiService;

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
}
