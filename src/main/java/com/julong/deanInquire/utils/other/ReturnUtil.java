package com.julong.deanInquire.utils.other;

import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.utils.other.constants.Constants;
import com.julong.deanInquire.utils.other.constants.ErrorEnum;

public class ReturnUtil {

    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    /**
     * 返回一个返回码为200的json
     */
    public static JSONObject successJson(Object info) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("statusCode", Constants.SUCCESS_CODE);
        resultJson.put("errMsg", Constants.SUCCESS_MSG);
        resultJson.put("data", info);
        return resultJson;
    }

    /**
     * 返回错误信息JSON
     */
    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("statusCode", errorEnum.getErrorCode());
        resultJson.put("errMsg", errorEnum.getErrorMsg());
        resultJson.put("data", new JSONObject());
        return resultJson;
    }


    /**
     * 返回一个带分页总数的json
     */
    public static JSONObject successPage(Object info,int totalPage) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("statusCode", Constants.SUCCESS_CODE);
        resultJson.put("errMsg", Constants.SUCCESS_MSG);
        resultJson.put("data", info);
        resultJson.put("totalPage", totalPage);
        return resultJson;
    }


}
