package di.yang.Dao.web;

import di.yang.module.web.WebProcessStep;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangdi on 2019/12/7
 */
public interface WebProcessStepDao {
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

    /**
     * 通过webcaseid查找测试步骤
     * @param webcaseId web测试用例id
     * @return
     */
   List<WebProcessStep> selectWebProcessStepByWebcaseId(@Param("webcaseId") int webcaseId);
}
