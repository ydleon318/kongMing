package di.yang.service.impl.web;

import di.yang.Dao.web.WebProcessTestDao;
import di.yang.module.web.WebProcessTest;
import di.yang.service.web.WebProcessTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yangdi
 * @Date 2019/12/6 15:11
 **/
@Service
@Repository
public class WebProcessTestServiceImpl implements WebProcessTestService {

    @Autowired
    private WebProcessTestDao webProcessTestDao;

    @Override
    public boolean addWebProcessTestCase(WebProcessTest webProcessTest) {
        return webProcessTestDao.addWebProcessTestCase(webProcessTest);
    }

    @Override
    public boolean updataWebProcessTestCase(WebProcessTest webProcessTest) {
        return webProcessTestDao.updataWebProcessTestCase(webProcessTest);
    }

    @Override
    public List<WebProcessTest> selectWebProcessTestCase(WebProcessTest webProcessTest) {
        return webProcessTestDao.selectWebProcessTestCase(webProcessTest);
    }
}
