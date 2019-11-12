package di.yang.Dao.api;

import di.yang.modle.api.ApiProcessStep;

import java.util.List;

public interface ApiProcessStepDao {
    /**
     * 添加业务流程接口测试步骤
     * @param apiProcessStep
     * @return
     */
    boolean addApiProcessStep (ApiProcessStep apiProcessStep);

    /**
     * 修改业务流程接口测试步骤
     * @param apiProcessStep
     * @return
     */
    boolean updataApiProcessStep (ApiProcessStep apiProcessStep);

    /**
     * 查询业务流程接口测试步骤
     * @param apiProcessStep
     * @return
     */
    List<ApiProcessStep> getApiProcessStepInfo (ApiProcessStep apiProcessStep);
}
