package di.yang.Dao.api;


import di.yang.modle.api.ApiSingleTest;
import java.util.List;

public interface apiSingleTestDao {
    /**
     * 添加单一接口测试用例
     * @param apiSingle
     * @return
     */
    boolean addApiSingle(ApiSingleTest apiSingle);

    /**
     * 修改单一接口测试用例
     * @param apiSingle
     * @return
     */
    boolean updataApiSingleTest(ApiSingleTest apiSingle);

    /**
     * 查询单一接口测试用例
     * @param apiSingle
     * @return
     */
    List<ApiSingleTest> getApiSingleTestInfo(ApiSingleTest apiSingle);
}