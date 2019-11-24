package di.yang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    public static final String RESPONSE_RESULT = "data";
    public static final String RESPONSE_TAG = "status";
    public static final String RESPONSE_MSG = "message";
    /** 成功状态码 */
    public static final int SUCCESS = 0;
    /** 失败状态码 */
    public static final int ERROR = -1;

    public static ResponseEntity<?> buildSuccessResponse(Object obj) {
        final Map<String, Object> resulpMap = new HashMap<>();
        resulpMap.put(RESPONSE_TAG, SUCCESS);
        resulpMap.put(RESPONSE_RESULT, obj);
        return new ResponseEntity<>(resulpMap, HttpStatus.OK);
    }


    public static ResponseEntity<?> buildErrorResponse(Object obj) {
        final Map<String, Object> resulpMap = new HashMap<>();
        resulpMap.put(RESPONSE_TAG, ERROR);
        resulpMap.put(RESPONSE_MSG, obj);
        resulpMap.put("msg","请求未成功");
        return new ResponseEntity<>(resulpMap, HttpStatus.OK);
    }

    public static ResponseEntity<?> buildInvalidResponse(Object obj, Integer responseStatus) {
        final Map<String, Object> resulpMap = new HashMap<>();
        resulpMap.put(RESPONSE_TAG, responseStatus);
        resulpMap.put(RESPONSE_MSG, obj);
        return new ResponseEntity<>(resulpMap, HttpStatus.OK);
    }

}
