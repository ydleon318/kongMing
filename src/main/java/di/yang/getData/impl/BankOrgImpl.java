package di.yang.getData.impl;

import di.yang.getData.BankOrg;
import di.yang.getData.BaseGetData;
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
