package di.yang.service.apiService;

import di.yang.modle.api.ApiSingleTest;

import java.util.List;

public interface apiSingleTestService {
    boolean addApiSingle (ApiSingleTest apiSingle);

    boolean updataApiSingleTest(ApiSingleTest apiSingle);

    List<ApiSingleTest> getApiSingleTestInfo(ApiSingleTest apiSingle);
}
