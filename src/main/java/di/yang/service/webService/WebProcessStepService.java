package di.yang.service.webService;

import di.yang.module.web.WebProcessStep;

import java.util.List;
import java.util.Map;

/**
 * Created by yangdi on 2019/12/7
 */
public interface WebProcessStepService {
    /**
     * 添加web测试用例步骤
     * @param webProcessStep 实体类
     * @return
     */
    boolean addWebProcessStep(WebProcessStep webProcessStep);

    /**
     * 修改web测试用例步骤
     * @param webProcessStep 实体类
     * @return
     */
    boolean updataWebProcessStep(WebProcessStep webProcessStep);

    /**
     * 查询web测试用例步骤
     * @param webProcessStep 实体类
     * @return
     */
    List<WebProcessStep> selectWebProcessStep(WebProcessStep webProcessStep);


}
