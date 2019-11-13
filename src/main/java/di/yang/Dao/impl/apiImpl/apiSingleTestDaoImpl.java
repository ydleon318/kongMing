package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.apiSingleTestDao;
import di.yang.modle.api.apiSingleTest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class apiSingleTestDaoImpl extends BaseGetData implements apiSingleTestDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addApiSingle(apiSingleTest apiSingle) {
        boolean flag = addDataBaseInfo(dataBasexml,"addApiSingleTest",apiSingle);
        return flag;
    }

    @Override
    public boolean updataApiSingleTest(apiSingleTest apiSingle) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataApiSingleTest",apiSingle);
        return flag;
    }

    @Override
    public List<apiSingleTest> getApiSingleTestInfo(apiSingleTest apiSingle) {
        List<apiSingleTest> apiSingleTest = getDataBaseListInfo(dataBasexml,"getApiSingleTestInfo",apiSingle);
        return apiSingleTest;
    }
}
