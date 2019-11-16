package di.yang.Dao.impl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.BatchDate;
import di.yang.module.updateBatchDateVo;
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
