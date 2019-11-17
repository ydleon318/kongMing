import di.yang.Dao.bugManagement.BugManagementDao;
import di.yang.Dao.impl.bugManagementImpl.BugManagementDaoImpl;
import di.yang.module.bugManagement.BugManagement;
import org.testng.annotations.Test;


public class demoTest {

    private BugManagementDao bugmanage = new BugManagementDaoImpl();
    BugManagement bugManagement = new BugManagement();

    public boolean addBug(String apiname, String requestparam, String expectresult, String actualresult, int buglevel, String bugcreater, String bugassign, int productid) {
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

    @Test
    public void test(){
        boolean flag =  addBug("测试用的","{'json':'222'}","通过","没通过",4,"我自己","she",2);
        System.out.printf(String.valueOf(flag));
    }
}
