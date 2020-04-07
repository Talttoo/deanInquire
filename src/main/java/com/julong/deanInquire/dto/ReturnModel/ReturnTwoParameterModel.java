package com.julong.deanInquire.dto.ReturnModel;

import com.alibaba.fastjson.JSON;

public class ReturnTwoParameterModel {
    private Integer statusCode  ;
    private JSON data;
    private JSON data_2;
    private String errMsg;

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

    public JSON getData_2() {
        return data_2;
    }

    public void setData_2(JSON data_2) {
        this.data_2 = data_2;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ReturnTwoParameterModel{" +
                "statusCode=" + statusCode +
                ", data=" + data +
                ", data_2=" + data_2 +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
