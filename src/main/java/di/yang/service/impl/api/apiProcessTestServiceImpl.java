package di.yang.service.impl.api;

import di.yang.Dao.api.apiProcessTestDao;
import di.yang.module.api.apiProcessTest;
import di.yang.service.apiService.apiProcessTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class apiProcessTestServiceImpl implements apiProcessTestService {

    @Autowired
    private apiProcessTestDao apiprocesstestDao;

    @Override
    public boolean addApiProcessTest(apiProcessTest apiprocesstest) {
        boolean flag = apiprocesstestDao.addApiProcessTest(apiprocesstest);
        return flag;
    }

    @Override
    public boolean updataApiProcessTest(apiProcessTest apiprocesstest) {
        boolean flag = apiprocesstestDao.updataApiProcessTest(apiprocesstest);
        return flag;
    }

    @Override
    public List<apiProcessTest> selectApiProcessTest(apiProcessTest apiprocesstest) {
        apiprocesstest.setPagenum((apiprocesstest.getPagenum()-1)*apiprocesstest.getPagesize());
        return apiprocesstestDao.selectApiProcessTestInfo(apiprocesstest);
    }
}
