package com.hrbb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hrbb.controllerService.singleApiCasesService;
import com.hrbb.modle.CasesVo;
import com.hrbb.modle.executeCustomizeCaseLog;
import com.hrbb.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/submit")
public class singleApiCasesController extends BaseController{
//    private static final Logger LOG = LoggerFactory.getLogger(singleApiCasesController.class);
    private static Logger log = LoggerFactory.getLogger(singleApiCasesController.class.getName());
    @Autowired
    public singleApiCasesService addcases;

    @PostMapping("/addcase")
    public ResponseEntity<?> addCase(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        log.info("param is--->{}",param);
        CasesVo casesVo = JSON.toJavaObject(param,CasesVo.class);
        boolean flag = addcases.addCase(casesVo);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse("error");
        }
        return result;
    }

    @PostMapping("/updataCase")
    public ResponseEntity<?> updataCase(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        log.info("param is--->{}",param);
        CasesVo casesVo = JSON.toJavaObject(param,CasesVo.class);
        boolean flag = addcases.updataCase(casesVo);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse("error");
        }
        return result;
    }

    @PostMapping("/delCase")
    public ResponseEntity<?> delCase(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        log.info("param is--->{}",param);
        boolean flag = addcases.delCase(param.getInteger("caseId"));
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse("error");
        }
        return result;
    }

    @GetMapping("/selectCases")
    public JSONObject selectCases(@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        log.info("param is--->{}",param);
        CasesVo cases = JSON.toJavaObject(param,CasesVo.class);
        reponse.put("data",addcases.selectCases(cases));
        log.info("response is--->{}",reponse);
        return reponse;
    }

    @PostMapping("/runCustomizeTestCase")
    public ResponseEntity<?> executCustomizeTestCase(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        log.info("param is--->{}",param);
        boolean flag = addcases.runCustomTestCase(param.getInteger("caseId"));
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse("error");
        }
        return result;
    }

    @GetMapping("/getExecutedCaseLog")
    public JSONObject getExecutedCaseLog(@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        log.info("param is--->{}",param);
        executeCustomizeCaseLog getlog = addcases.getExecutedCaseLog(param.getInteger("caseId"));
        reponse.put("data",getlog);
        log.info("response is--->{}",reponse);
        return  reponse;
    }

}
