package di.yang.service.apiService;

import di.yang.Vo.api.apiSingleTest;

import java.util.List;

public interface apiSingleTestService {
    boolean addApiSingle (apiSingleTest apiSingle);

    boolean updataApiSingleTest(apiSingleTest apiSingle);

    List<apiSingleTest> getApiSingleTestInfo(apiSingleTest apiSingle);
}
