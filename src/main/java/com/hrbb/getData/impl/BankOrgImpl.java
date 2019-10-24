package com.hrbb.getData.impl;

import com.hrbb.getData.BankOrg;
import com.hrbb.getData.BaseGetData;
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
