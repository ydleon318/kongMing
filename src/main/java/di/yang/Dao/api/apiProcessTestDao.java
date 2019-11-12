package di.yang.Dao.api;

import di.yang.modle.api.ApiProcessTest;

import java.util.List;

public interface apiProcessTestDao {
    /**
     * 添加业务流程测试用例
     * @param apiProcessTest
     * @return
     */
    boolean addApiProcessTest (ApiProcessTest apiProcessTest);

    /**
     * 更新业务流程测试用例
     * @param apiProcessTest
     * @return
     */
    boolean updataApiProcessTest (ApiProcessTest apiProcessTest);

    /**
     * 查询业务流程测试用例
     * @param apiProcessTest
     * @return
     */
    List<ApiProcessTest> getApiProcessTestInfo (ApiProcessTest apiProcessTest);
}
