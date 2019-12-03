package di.yang.Dao.api;


import di.yang.module.api.apiSingleTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface apiSingleTestDao {
    /**
     * 添加单一接口测试用例
     * @param apiSingle
     * @return
     */
    boolean addApiSingle(apiSingleTest apiSingle);

    /**
     * 修改单一接口测试用例
     * @param apiSingle
     * @return
     */
    boolean updataApiSingleTest(apiSingleTest apiSingle);

    /**
     * 查询单一接口测试用例
     * @param apiSingle
     * @return
     */
    List<apiSingleTest> getApiSingleTestInfo(apiSingleTest apiSingle);

    /**
     *添加测试结果
     */
    boolean updataApiSingleTestResult(apiSingleTest apiSingle);

    /**
     * 通过用例编号查找单一接口测试用例
     * @param id 单一接口用例编号
     * @return apiSingleTest实体类
     */
    apiSingleTest selectApiSingleTestByid(@Param("id") int id);
}
