package di.yang.service.webService;

import di.yang.module.web.WebProcessTest;

import java.util.List;

/**
 * @Author yangdi
 * @Date 2019/12/6 14:55
 **/
public interface WebProcessTestService {
    /**
     * 添加web流程测试用例
     * @param webProcessTest
     * @return
     */
    boolean addWebProcessTestCase(WebProcessTest webProcessTest);

    /**
     * 修改web流程测试用例
     * @param webProcessTest
     * @return
     */
    boolean updataWebProcessTestCase (WebProcessTest webProcessTest);

    /**
     * 查询web流程测试用例
     * @param webProcessTest
     * @return
     */
    List<WebProcessTest> selectWebProcessTestCase (WebProcessTest webProcessTest);
}
