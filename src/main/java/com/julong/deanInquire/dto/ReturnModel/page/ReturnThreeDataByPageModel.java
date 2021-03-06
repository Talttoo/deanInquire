package com.julong.deanInquire.dto.ReturnModel.page;

import com.alibaba.fastjson.JSON;

public class ReturnThreeDataByPageModel {
    private Integer statusCode  ;
    private Integer totalPage  ;
    private JSON data;
    private JSON data_2;
    private JSON data_3;
    private String errMsg;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
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

    public JSON getData_3() {
        return data_3;
    }

    public void setData_3(JSON data_3) {
        this.data_3 = data_3;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ReturnThreeDataByPageModel{" +
                "statusCode=" + statusCode +
                ", totalPage=" + totalPage +
                ", data=" + data +
                ", data_2=" + data_2 +
                ", data_3=" + data_3 +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
