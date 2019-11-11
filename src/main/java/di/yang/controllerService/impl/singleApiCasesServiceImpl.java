package di.yang.controllerService.impl;

import di.yang.controllerService.singleApiCasesService;
import di.yang.getData.TaskCases;
import di.yang.modle.CasesVo;
import di.yang.modle.executeCustomizeCaseLog;
import di.yang.utils.BetterHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class singleApiCasesServiceImpl implements singleApiCasesService {
    @Autowired
    private TaskCases taskCases;
    @Autowired
    private CasesVo casesvo;
    @Autowired
    private BetterHttpClient httpClient;

    @Autowired
    private executeCustomizeCaseLog executeCustomizeCaseLog;

    @Override
    public boolean addCase(CasesVo casevo) {
        boolean flag = taskCases.addCase(casevo);
        return flag;
    }

    @Override
    public boolean updataCase(CasesVo casesvo) {
        boolean flag = taskCases.updataCase(casesvo);
        return flag;
    }

    @Override
    public boolean delCase(int caseId) {
        boolean flag = taskCases.delCase(caseId);
        return flag;
    }

    @Override
    public List<CasesVo> selectCases(CasesVo casesVo) {
        List<CasesVo> casesVos = taskCases.selectCases(casesVo);
        return casesVos;
    }

    @Override
    public boolean runCustomTestCase(int caseId) {
        try{
            casesvo = taskCases.getExecutTestCase(caseId);
            executeCustomizeCaseLog.setCaseId(caseId);
            executeCustomizeCaseLog.setApiName(casesvo.getApiName());
            executeCustomizeCaseLog.setProductName(casesvo.getProductName());
            executeCustomizeCaseLog.setTester(casesvo.getTester());
            executeCustomizeCaseLog.setExecutUrl(casesvo.getUrl());
            httpClient.doPostWithJson(casesvo.getUrl(), casesvo.getRequestParams());
            executeCustomizeCaseLog.setResponseInfo(BetterHttpClient.responseStr);
            executeCustomizeCaseLog.setStatusCode(BetterHttpClient.codeStuts);
            taskCases.addExecutCustomizeTestCaseLog(executeCustomizeCaseLog);
            return updataExecutTestCaseFlag(caseId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public executeCustomizeCaseLog getExecutedCaseLog(int caseId) {
        return taskCases.getExecutedCaseLog(caseId);
    }

    @Override
    public boolean updataExecutTestCaseFlag(int caseId) {
        return taskCases.updataExecutTestCaseFlag(caseId);
    }
}
