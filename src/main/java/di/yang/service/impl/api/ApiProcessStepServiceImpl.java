package di.yang.service.impl.api;

import di.yang.Dao.api.ApiProcessStepDao;
import di.yang.module.api.apiProcessStep;
import di.yang.service.apiService.ApiProcessStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class ApiProcessStepServiceImpl implements ApiProcessStepService {

    @Autowired
    private ApiProcessStepDao apiProcessStepDao;

    @Override
    public boolean addApiProcessStep(apiProcessStep apistep) {
        boolean flag = apiProcessStepDao.addApiProcessStep(apistep);
        return flag;
    }

    @Override
    public boolean updataApiProcessStep(apiProcessStep apistep) {
        boolean flag = apiProcessStepDao.updataApiProcessStep(apistep);
        return flag;
    }

    @Override
    public List<apiProcessStep> selectApiProcessStep(apiProcessStep apistep) {
        List<apiProcessStep> lists = apiProcessStepDao.selectApiProcessStepInfo(apistep);
        return lists;
    }
}
