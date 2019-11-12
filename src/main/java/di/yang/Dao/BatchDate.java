package di.yang.Dao;

import di.yang.modle.updateBatchDateVo;

public interface BatchDate {
    boolean updateBatchDate(updateBatchDateVo updateBatchDateVo, String environment);
}
