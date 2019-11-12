package di.yang.Dao.impl.apiImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.api.apiSingleTestDao;
import di.yang.modle.api.ApiSingleTest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class apiSingleTestDaoImpl extends BaseGetData implements apiSingleTestDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addApiSingle(ApiSingleTest apiSingle) {
        boolean flag = addDataBaseInfo(dataBasexml,"addApiSingleTest",apiSingle);
        return flag;
    }

    @Override
    public boolean updataApiSingleTest(ApiSingleTest apiSingle) {
        boolean flag = upDataBaseInfo(dataBasexml,"updataApiSingleTest",apiSingle);
        return flag;
    }

    @Override
    public List<ApiSingleTest> getApiSingleTestInfo(ApiSingleTest apiSingle) {
        List<ApiSingleTest> apiSingleTest = getDataBaseListInfo(dataBasexml,"getApiSingleTestInfo",apiSingle);
        return apiSingleTest;
    }
}
