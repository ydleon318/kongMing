package di.yang.service.bugService;


import di.yang.module.bugManagement.BugManagement;

import java.util.List;

public interface BugManageService {
    /**
     * 添加缺陷
     * @param
     * @return
     */
    boolean addBug (String apiname,String requestparam,String expectresult,String actualresult,int buglevel,String bugcreater,String bugassign,int productid);

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
    List<BugManagement> selectbugs (BugManagement bugManagement);
}
