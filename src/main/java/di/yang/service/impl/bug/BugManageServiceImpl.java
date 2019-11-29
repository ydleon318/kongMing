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

    @Autowired
    private BugManagement bugManagement;

    @Override
    public boolean addBug(String apiname,String requestparam,String expectresult,String actualresult,int buglevel,String bugcreater,String bugassign,int productid) {
        bugManagement.setBugname(apiname+"_出错了");
        bugManagement.setBugdetail("[请求数据]：\r"+requestparam+"\r"+"[预期结果]：\r"+expectresult+"\r"+"[实际结果]：\r"+actualresult);
        bugManagement.setBugstatus("未解决");
        bugManagement.setBuglevel(buglevel);
        bugManagement.setBugcreater(bugcreater);
        bugManagement.setBugassign(bugassign);
        bugManagement.setProductId(productid);
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
        bugManagement.setPagenum((bugManagement.getPagenum()-1)*bugManagement.getPagesize());
        return bugmanage.selectBugs(bugManagement);
    }
}
