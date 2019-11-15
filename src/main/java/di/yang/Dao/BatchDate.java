package di.yang.Dao;

import di.yang.Vo.updateBatchDateVo;

public interface BatchDate {
    boolean updateBatchDate(updateBatchDateVo updateBatchDateVo, String environment);
}
