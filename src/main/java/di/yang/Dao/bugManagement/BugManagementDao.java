package di.yang.Dao.bugManagement;

import di.yang.module.bugManagement.BugManagement;

import java.util.List;

public interface BugManagementDao {
    /**
     * 添加缺陷
     * @param bugManagement
     * @return
     */
    boolean addBug (BugManagement bugManagement);

    /**
     * 修改缺陷状态
     * @param bugManagement
     * @return
     */
    boolean updatabug (BugManagement bugManagement);

    /**
     * 查询缺陷，返回缺陷列表
     * @param bugManagement
     * @return
     */
    List<BugManagement> selectBugs (BugManagement bugManagement);
}
