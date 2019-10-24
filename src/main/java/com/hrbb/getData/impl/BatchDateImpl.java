package com.hrbb.getData.impl;

import com.hrbb.getData.BaseGetData;
import com.hrbb.getData.BatchDate;
import com.hrbb.modle.updateBatchDateVo;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDateImpl extends BaseGetData implements BatchDate {
    String dataBasexml = "Oracle_zhangwu_Config.xml";
    @Override
    public boolean updateBatchDate(updateBatchDateVo updateBatchDateVo,String environment) {
        boolean flag = upDataBaseInfo(dataBasexml,environment,"updataBatchDate",updateBatchDateVo);
        return flag;
    }
}
