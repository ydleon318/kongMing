package di.yang.service;


import di.yang.module.CasesVo;
import di.yang.module.executeCustomizeCaseLog;

import java.util.List;

public interface singleApiCasesService {
    boolean addCase(CasesVo casevo);

    boolean updataCase(CasesVo casesvo);

    boolean delCase(int caseId);

    List<CasesVo> selectCases(CasesVo casesVo);

    boolean runCustomTestCase(int caseId);

    executeCustomizeCaseLog getExecutedCaseLog(int caseId);

    boolean updataExecutTestCaseFlag(int caseId);
}
