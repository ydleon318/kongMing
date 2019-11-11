package di.yang.getData.impl;

import di.yang.getData.BaseGetData;
import di.yang.getData.BatchDate;
import di.yang.modle.updateBatchDateVo;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDateImpl extends BaseGetData implements BatchDate {
    String dataBasexml = "Oracle_zhangwu_Config.xml";
    @Override
    public boolean updateBatchDate(updateBatchDateVo updateBatchDateVo, String environment) {
        boolean flag = upDataBaseInfo(dataBasexml,environment,"updataBatchDate",updateBatchDateVo);
        return flag;
    }
}
