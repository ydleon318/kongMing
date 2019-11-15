package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.ApiProcessStepDao;
import di.yang.Vo.api.apiProcessStep;

import java.util.List;

public class ApiProcessStepDaoImpl extends BaseGetData implements ApiProcessStepDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addApiProcessStep(apiProcessStep apiProcessStep) {
        boolean flag = addDataBaseInfo(dataBasexml,"addApiProcessStep",apiProcessStep);
        return flag;
    }

    @Override
    public boolean updataApiProcessStep(apiProcessStep apiProcessStep) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataApiProcessStep",apiProcessStep);
        return flag;
    }

    @Override
    public List<apiProcessStep> getApiProcessStepInfo(apiProcessStep apiProcessStep) {
        List<di.yang.Vo.api.apiProcessStep> apiProcessSteps = getDataBaseListInfo(dataBasexml,"getApiProcessStepInfo",apiProcessStep);
        return apiProcessSteps;
    }
}
