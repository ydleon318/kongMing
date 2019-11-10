package di.yang.controllerService;


import di.yang.modle.CasesVo;
import di.yang.modle.executeCustomizeCaseLog;

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
