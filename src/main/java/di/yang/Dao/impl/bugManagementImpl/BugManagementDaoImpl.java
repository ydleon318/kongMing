package di.yang.Dao.impl.bugManagementImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.bugManagement.BugManagementDao;
import di.yang.module.bugManagement.BugManagement;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BugManagementDaoImpl extends BaseGetData implements BugManagementDao {
    String dataBasexml = "KongmingDB_config.xml";
    @Override
    public boolean addBug(BugManagement bugManagement) {
        boolean data = addDataBaseInfo(dataBasexml,"addBug",bugManagement);
        return data;
    }

    @Override
    public boolean updatabug(BugManagement bugManagement) {
        boolean data = upDataBaseInfo(dataBasexml,"updataBugData",bugManagement);
        return data;
    }

    @Override
    public List<BugManagement> selectBugs(BugManagement bugManagement) {
        List<BugManagement> bugs = getDataBaseListInfo(dataBasexml,"selectBugData",bugManagement);
        return bugs;
    }
}
