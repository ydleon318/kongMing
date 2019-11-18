package di.yang.controller.bugController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.bugManagement.BugManagement;
import di.yang.service.bugService.BugManageService;
import di.yang.utils.JsonUtils;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bugs")
public class BugManagementController extends BaseController {

    @Autowired
    private BugManageService bugManageService;

    @PostMapping(value = "/updataBugStatus")
    public ResponseEntity<?> updataBugStatus (@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("updataBugStatus param is--->"+param);
        BugManagement bugManagement = JSON.toJavaObject(param, BugManagement.class);
        boolean flag = bugManageService.updatabug(bugManagement);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("updataBugStatusResponse is----->"+result);
        return result;
    }

    @PostMapping(value = "/selectBugs")
    public JSONObject selectBugs (@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectBugs param is--->"+param);
        BugManagement bugManagement = JSON.toJavaObject(param, BugManagement.class);
        reponse.put("data", JsonUtils.listWithDateToJson(bugManageService.selectbugs(bugManagement),true));
        Tools.step("selectBugs response is--->"+reponse);
        return reponse;
    }

}
