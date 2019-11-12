package di.yang.service.impl.api;

import di.yang.Dao.api.apiSingleTestDao;
import di.yang.modle.api.ApiSingleTest;
import di.yang.service.apiService.apiSingleTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class apiSingleTestServiceImpl implements apiSingleTestService {
    @Autowired
    private apiSingleTestDao apisingle;

    @Autowired
    private ApiSingleTest apiSingleTest;

    @Override
    public boolean addApiSingle(ApiSingleTest apiSingle) {
        boolean data = apisingle.addApiSingle(apiSingleTest);
        return data;
    }

    @Override
    public boolean updataApiSingleTest(ApiSingleTest apiSingle) {
        boolean data = apisingle.updataApiSingleTest(apiSingle);
        return data;
    }

    @Override
    public List<ApiSingleTest> getApiSingleTestInfo(ApiSingleTest apiSingle) {
        List<ApiSingleTest> api = apisingle.getApiSingleTestInfo(apiSingle);
        return api;
    }
}
