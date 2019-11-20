package di.yang.service.apiService;

import di.yang.module.api.apiProcessTest;

import java.util.List;


public interface apiProcessTestService {
    /**
     *添加业务流程测试用例
     * @param apiprocesstest
     * @return
     */
    boolean addApiProcessTest (apiProcessTest apiprocesstest);

    /**
     * 修改业务流程测试用例
     * @param apiprocesstest
     * @return
     */
    boolean updataApiProcessTest(apiProcessTest apiprocesstest);

    /**
     * 查询业务流程测试用例
     * @param apiprocesstest
     * @return
     */
    List<apiProcessTest> selectApiProcessTest (apiProcessTest apiprocesstest);
}
