package com.julong.deanInquire.dto.ReturnModel;

import com.alibaba.fastjson.JSON;

public class ReturnParameterModel {
    private Integer statusCode  ;
    private JSON data;
    private String errMsg;

    public ReturnParameterModel() {
    }

    public ReturnParameterModel(Integer statusCode, JSON data, String errMsg) {
        this.statusCode = statusCode;
        this.data = data;
        this.errMsg = errMsg;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public JSON getData() {
        return data;
    }

    public void setData(JSON data) {
        this.data = data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
