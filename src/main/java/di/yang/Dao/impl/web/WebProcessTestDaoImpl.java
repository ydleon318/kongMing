package di.yang.Dao.impl.web;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.web.WebProcessTestDao;
import di.yang.module.web.WebProcessTest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yangdi
 * @Date 2019/12/6 14:40
 **/
@Repository
public class WebProcessTestDaoImpl extends BaseGetData implements WebProcessTestDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addWebProcessTestCase(WebProcessTest webProcessTest) {
        return addDataBaseInfo(dataBasexml,"addWebProcessTestCase",webProcessTest);
    }

    @Override
    public boolean updataWebProcessTestCase(WebProcessTest webProcessTest) {
        return upDataBaseInfo(dataBasexml,"updataWebProcessTestCase",webProcessTest);
    }

    @Override
    public List<WebProcessTest> selectWebProcessTestCase(WebProcessTest webProcessTest) {
        return getDataBaseListInfo(dataBasexml,"selectWebProcessTestCase",webProcessTest);
    }
}
