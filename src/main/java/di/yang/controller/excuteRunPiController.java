package di.yang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controllerService.excuteRunPi;
import di.yang.modle.updateBatchDateVo;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/excute")
public class excuteRunPiController extends BaseController {
    @Autowired
    private excuteRunPi excuteRunPi;

    @Autowired
    private updateBatchDateVo update;

    @PostMapping(value = "/runpi")
    public ResponseEntity<?> excuteRunPi(@RequestBody JSONObject param){
        boolean excuteUIflag = false;
        ResponseEntity<?> result = null;
        Tools.step(param);
        update.setChannelNo(param.getString("channelNo"));
        update.setBatchDate(param.getString("batchDate"));
        JSONObject arrivalNoticeParam = new JSONObject();
        arrivalNoticeParam.put("channelNo",param.getString("channelNo"));
        arrivalNoticeParam.put("icode",param.getString("arrivalNoticeIcode"));
        arrivalNoticeParam.put("crtDate",param.getString("arrivalNoticeCrtDate"));
        boolean updateFlag = excuteRunPi.updateDB(update,Tools.getNextDay(param.getString("batchDate")),param.getString("environment"));
        boolean executArrivalNoticeFlag = excuteRunPi.executArrivalNotice(param.getString("arrivalNoticeIP"),arrivalNoticeParam);

        for (Object obj : JSON.parseArray(param.getJSONArray("taskId").toString())) {
            JSONObject jsonObject = (JSONObject) obj;
            excuteUIflag = excuteRunPi.excuteUI(jsonObject.getString("step"));
        }


//        boolean excuteUiFlag = excuteRunPi.excuteUI(param.getString("taskId"));
        boolean flag = updateFlag&&executArrivalNoticeFlag;
        if (flag&&excuteUIflag){
            result = buildSuccessResponse(flag&&excuteUIflag);
        }else {
            result = buildErrorResponse("error");
        }
        return result;
    }
}
