package di.yang.Dao.impl.web;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.web.WebProcessStepDao;
import di.yang.module.web.WebProcessStep;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by yangdi on 2019/12/7
 */
@Repository
public class WebProcessStepDaoImpl extends BaseGetData implements WebProcessStepDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addWebProcessStep(WebProcessStep webProcessStep) {
        return addDataBaseInfo(dataBasexml,"addWebProcessStep",webProcessStep);
    }

    @Override
    public boolean updataWebProcessStep(WebProcessStep webProcessStep) {
        return upDataBaseInfo(dataBasexml,"updataWebProcessStep",webProcessStep);
    }

    @Override
    public List<WebProcessStep> selectWebProcessStep(WebProcessStep webProcessStep) {
        return getDataBaseListInfo(dataBasexml,"selectWebProcessStep",webProcessStep);
    }

    @Override
    public List<WebProcessStep> selectWebProcessStepByWebcaseId(int webcaseId) {
        return getDataBaseListInfo(dataBasexml,"selectWebProcessStepByWebcaseId",webcaseId);
    }
}
