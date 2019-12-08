package di.yang.service.impl.web;

import di.yang.Dao.web.WebProcessStepDao;
import di.yang.module.web.WebProcessStep;
import di.yang.service.webService.WebProcessStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangdi on 2019/12/7
 */
@Service
@Repository
public class WebProcessStepServiceImpl implements WebProcessStepService {
    @Autowired
    private WebProcessStepDao webProcessStepDao;

    @Override
    public boolean addWebProcessStep(WebProcessStep webProcessStep) {
        return webProcessStepDao.addWebProcessStep(webProcessStep);
    }

    @Override
    public boolean updataWebProcessStep(WebProcessStep webProcessStep) {
        return webProcessStepDao.updataWebProcessStep(webProcessStep);
    }

    @Override
    public List<WebProcessStep> selectWebProcessStep(WebProcessStep webProcessStep) {
        webProcessStep.setPagenum((webProcessStep.getPagenum()-1)*webProcessStep.getPagesize());
        return webProcessStepDao.selectWebProcessStep(webProcessStep);
    }
}
