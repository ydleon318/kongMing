package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.apiProcessTestDao;
import di.yang.modle.api.ApiProcessTest;

import java.util.List;

public class apiProcessTestDaoImpl extends BaseGetData implements apiProcessTestDao {
    String dataBasexml = "KongmingDB_config.xml";

    @Override
    public boolean addApiProcessTest(ApiProcessTest apiProcessTest) {
        boolean flag = addDataBaseInfo(dataBasexml,"addApiProcessTest",apiProcessTest);
        return flag;
    }

    @Override
    public boolean updataApiProcessTest(ApiProcessTest apiProcessTest) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataApiProcessTest",apiProcessTest);
        return flag;
    }

    @Override
    public List<ApiProcessTest> getApiProcessTestInfo(ApiProcessTest apiProcessTest) {
        List<ApiProcessTest> apiProcessTests = getDataBaseListInfo(dataBasexml,"getApiProcessTestInfo",apiProcessTest);
        return apiProcessTests;
    }
}
