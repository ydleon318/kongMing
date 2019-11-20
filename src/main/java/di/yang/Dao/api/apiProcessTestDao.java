package di.yang.Dao.api;

import di.yang.module.api.apiProcessTest;

import java.util.List;

public interface apiProcessTestDao {
    /**
     * 添加业务流程测试用例
     * @param apiProcessTest
     * @return
     */
    boolean addApiProcessTest (apiProcessTest apiProcessTest);

    /**
     * 更新业务流程测试用例
     * @param apiProcessTest
     * @return
     */
    boolean updataApiProcessTest (apiProcessTest apiProcessTest);

    /**
     * 查询业务流程测试用例
     * @param apiProcessTest
     * @return
     */
    List<apiProcessTest> selectApiProcessTestInfo (apiProcessTest apiProcessTest);
}
