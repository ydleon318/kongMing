package di.yang.service;

import com.alibaba.fastjson.JSONObject;
import di.yang.module.updateBatchDateVo;

public interface excuteRunPi {
    boolean updateDB(updateBatchDateVo updateBatchDateVo,String workDate,String environment);

    boolean excuteUI(String str);

    boolean executArrivalNotice(String url,JSONObject param);
}
