package di.yang.Dao.impl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.TaskCases;
import di.yang.modle.CasesVo;
import di.yang.modle.executeCustomizeCaseLog;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TaskCasesImpl extends BaseGetData implements TaskCases {
    String dataBasexml = "Mysql_TestCase_Config.xml";

    @Override
    public boolean addCase(CasesVo casesvo) {
        boolean flag = addDataBaseInfo(dataBasexml,"addCase",casesvo);
        return flag;
    }

    @Override
    public boolean updataCase(CasesVo casesvo) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataCase",casesvo);
        return flag;
    }

    @Override
    public boolean delCase(int caseId) {
        boolean data = upDataBaseInfo(dataBasexml,"delCase",caseId);
        return data;
    }

    @Override
    public List<CasesVo> selectCases(CasesVo casesVo) {
        List<CasesVo> cases = getDataBaseListInfo(dataBasexml,"getCaseInfo",casesVo);
        return cases;
    }

    @Override
    public CasesVo getExecutTestCase(int caseId) {
        CasesVo casesvo = getDataBaseInfo(dataBasexml,"getExecutTestCase",caseId);
        return casesvo;
    }

    @Override
    public boolean addExecutCustomizeTestCaseLog(executeCustomizeCaseLog caseLog) {
        boolean flag = addDataBaseInfo(dataBasexml,"insertExecutCustomTestCaseLog",caseLog);
        return flag;
    }

    @Override
    public executeCustomizeCaseLog getExecutedCaseLog(int caseId) {
        executeCustomizeCaseLog executeCase = getDataBaseInfo(dataBasexml,"getExecutedCaseLog",caseId);
        return executeCase;
    }

    @Override
    public boolean updataExecutTestCaseFlag(int caseId) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataExecutTestCaseFlag",caseId);
        return flag;
    }


}
