package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.ApiProcessStepDao;
import di.yang.module.api.apiProcessStep;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
    public List<apiProcessStep> selectApiProcessStepInfo(apiProcessStep apiProcessStep) {
        List<di.yang.module.api.apiProcessStep> apiProcessSteps = getDataBaseListInfo(dataBasexml,"getApiProcessStepInfo",apiProcessStep);
        return apiProcessSteps;
    }
}
