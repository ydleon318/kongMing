package di.yang.Dao;

import org.apache.ibatis.annotations.Param;

public interface BankOrg {
    boolean updateWorkDate(@Param("workDate") String workDate,String environment);
}
