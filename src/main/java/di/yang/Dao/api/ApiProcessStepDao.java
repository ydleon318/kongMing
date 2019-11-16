package di.yang.Dao.api;

import di.yang.module.api.apiProcessStep;

import java.util.List;

public interface ApiProcessStepDao {
    /**
     * 添加业务流程接口测试步骤
     * @param apiProcessStep
     * @return
     */
    boolean addApiProcessStep (apiProcessStep apiProcessStep);

    /**
     * 修改业务流程接口测试步骤
     * @param apiProcessStep
     * @return
     */
    boolean updataApiProcessStep (apiProcessStep apiProcessStep);

    /**
     * 查询业务流程接口测试步骤
     * @param apiProcessStep
     * @return
     */
    List<apiProcessStep> getApiProcessStepInfo (apiProcessStep apiProcessStep);
}
