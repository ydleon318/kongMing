package com.hrbb.getData;

import org.apache.ibatis.annotations.Param;

public interface BankOrg {
    boolean updateWorkDate(@Param("workDate") String workDate,String environment);
}
