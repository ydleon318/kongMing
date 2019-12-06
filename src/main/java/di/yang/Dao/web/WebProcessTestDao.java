package di.yang.Dao.web;

import di.yang.module.web.WebProcessTest;

import java.util.List;

/**
 * @Author yangdi
 * @Date 2019/12/6 14:05
 **/
public interface WebProcessTestDao {
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
