package di.yang.service.impl.bug;


import di.yang.Dao.bugManagement.BugManagementDao;
import di.yang.module.bugManagement.BugManagement;
import di.yang.service.bugService.BugManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class BugManageServiceImpl implements BugManageService {

    @Autowired
    private BugManagementDao bugmanage;

    @Override
    public boolean addBug(BugManagement bugManagement) {
        boolean flag = bugmanage.addBug(bugManagement);
        return flag;
    }

    @Override
    public boolean updatabug(BugManagement bugManagement) {
        boolean flag = bugmanage.updatabug(bugManagement);
        return flag;
    }

    @Override
    public List<BugManagement> selectbugs(BugManagement bugManagement) {
        List<BugManagement> bugs = bugmanage.selectBugs(bugManagement);
        return bugs;
    }
}
