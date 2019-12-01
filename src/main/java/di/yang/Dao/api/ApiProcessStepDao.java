package di.yang.Dao.api;

import di.yang.VO.AutoReplaceValueVo;
import di.yang.module.api.apiProcessStep;
import org.apache.ibatis.annotations.Param;

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
    List<apiProcessStep> selectApiProcessStepInfo (apiProcessStep apiProcessStep);

    /**
     * 通过被测产品编号查询测试步骤
     * @param apitestId
     * @return
     */
    List<apiProcessStep> selectApiProcessStepByProductId (@Param("apitestId") int apitestId);

    apiProcessStep selectApiProcessStepByApistep (apiProcessStep apiProcessStep);

    /**
     * 自动替换请求参数值更新库
     * @param replaceValueVo
     */
    boolean updataApiProcessStepRequest(AutoReplaceValueVo replaceValueVo);
}
