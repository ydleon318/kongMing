package com.hrbb.controllerService;

import com.alibaba.fastjson.JSONObject;
import com.hrbb.modle.updateBatchDateVo;

public interface excuteRunPi {
    boolean updateDB(updateBatchDateVo updateBatchDateVo,String workDate,String environment);

    boolean excuteUI(String str);

    boolean executArrivalNotice(String url,JSONObject param);
}
