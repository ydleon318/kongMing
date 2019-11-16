package di.yang.Dao;

import di.yang.module.updateBatchDateVo;

public interface BatchDate {
    boolean updateBatchDate(updateBatchDateVo updateBatchDateVo, String environment);
}
