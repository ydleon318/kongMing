package di.yang.service.apiService;

import com.alibaba.fastjson.JSONObject;
import di.yang.module.api.apiSingleTest;

import java.util.List;

public interface apiSingleTestService {
    /**
     * 添加单一接口测试用例
     * @param apiSingle
     * @return
     */
    boolean addApiSingle (apiSingleTest apiSingle);

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
     * 执行测试用例
     * @param json
     * @return
     */
    boolean executeCases(JSONObject json);
}
