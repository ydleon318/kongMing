package di.yang.Dao.impl;

import di.yang.Dao.BankOrg;
import di.yang.Dao.BaseGetData;
import org.springframework.stereotype.Repository;

@Repository
public class BankOrgImpl extends BaseGetData implements BankOrg {
    String dataBasexml = "Oracle_zhangwu_Config.xml";
    @Override
    public boolean updateWorkDate(String workDate,String environment) {
        boolean flag = upDataBaseInfo(dataBasexml,environment,"updataBankOrg",workDate);
        return flag;
    }
}
