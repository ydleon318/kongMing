package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.ApiProcessStepDao;
import di.yang.modle.api.ApiProcessStep;

import java.util.List;

public class ApiProcessStepDaoImpl extends BaseGetData implements ApiProcessStepDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addApiProcessStep(ApiProcessStep apiProcessStep) {
        boolean flag = addDataBaseInfo(dataBasexml,"addApiProcessStep",apiProcessStep);
        return flag;
    }

    @Override
    public boolean updataApiProcessStep(ApiProcessStep apiProcessStep) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataApiProcessStep",apiProcessStep);
        return flag;
    }

    @Override
    public List<ApiProcessStep> getApiProcessStepInfo(ApiProcessStep apiProcessStep) {
        List<ApiProcessStep> apiProcessSteps = getDataBaseListInfo(dataBasexml,"getApiProcessStepInfo",apiProcessStep);
        return apiProcessSteps;
    }
}
