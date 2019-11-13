package di.yang.service.impl.api;

import di.yang.Dao.api.apiSingleTestDao;
import di.yang.service.apiService.apiSingleTestService;
import di.yang.modle.api.apiSingleTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class apiSingleTestServiceImpl implements apiSingleTestService {
    @Autowired
    private apiSingleTestDao apisingleDao;

    @Autowired
    private di.yang.modle.api.apiSingleTest apiSingleTest;

    @Override
    public boolean addApiSingle(apiSingleTest apiSingle) {
        boolean data = apisingleDao.addApiSingle(apiSingle);
        return data;
    }

    @Override
    public boolean updataApiSingleTest(apiSingleTest apiSingle) {
        boolean data = apisingleDao.updataApiSingleTest(apiSingle);
        return data;
    }

    @Override
    public List<apiSingleTest> getApiSingleTestInfo(apiSingleTest apiSingle) {
        List<apiSingleTest> api = apisingleDao.getApiSingleTestInfo(apiSingle);
        return api;
    }
}
