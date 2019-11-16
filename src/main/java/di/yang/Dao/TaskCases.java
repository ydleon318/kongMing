package di.yang.Dao;

import di.yang.module.CasesVo;
import di.yang.module.executeCustomizeCaseLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TaskCases {
    /**
     * 添加测试用例
     * @param casesvo
     * @return
     */
    boolean addCase(CasesVo casesvo);

    /**
     * 修改测试用例
     * @param casesvo
     * @return
     */
    boolean updataCase(CasesVo casesvo);

    /**
     * 删除单一测试用例
     * @param caseId
     * @return
     */
    boolean delCase(@Param("caseId") int caseId);

    /**
     * 通过条件查询用例
     * @param casesVo
     * @return
     */
    List<CasesVo> selectCases(CasesVo casesVo);

    /**
     * 通过caseid查找需要执行的测试用例
     * @param caseId
     * @return
     */
    CasesVo getExecutTestCase(@Param("caseId") int caseId);

    /**
     * 接口测试执行结果入库
     * @param caseLog
     * @return
     */
    boolean addExecutCustomizeTestCaseLog(executeCustomizeCaseLog caseLog);

    executeCustomizeCaseLog getExecutedCaseLog(@Param("caseId") int caseId);

    boolean updataExecutTestCaseFlag(@Param("caseId") int caseId);
}
