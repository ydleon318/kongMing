package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.apiProcessTestDao;
import di.yang.Vo.api.apiProcessTest;

import java.util.List;

public class apiProcessTestDaoImpl extends BaseGetData implements apiProcessTestDao {
    String dataBasexml = "KongmingDB_config.xml";

    @Override
    public boolean addApiProcessTest(apiProcessTest apiProcessTest) {
        boolean flag = addDataBaseInfo(dataBasexml,"addApiProcessTest",apiProcessTest);
        return flag;
    }

    @Override
    public boolean updataApiProcessTest(apiProcessTest apiProcessTest) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataApiProcessTest",apiProcessTest);
        return flag;
    }

    @Override
    public List<apiProcessTest> getApiProcessTestInfo(apiProcessTest apiProcessTest) {
        List<di.yang.Vo.api.apiProcessTest> apiProcessTests = getDataBaseListInfo(dataBasexml,"getApiProcessTestInfo",apiProcessTest);
        return apiProcessTests;
    }
}
