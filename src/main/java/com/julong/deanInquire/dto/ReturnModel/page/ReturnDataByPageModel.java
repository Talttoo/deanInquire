package com.julong.deanInquire.dto.ReturnModel.page;

import com.alibaba.fastjson.JSON;

/**
 * 返回一个data的带分页JSON
 */
public class ReturnDataByPageModel {
    private Integer statusCode  ;
    private Integer totalPage  ;
    private JSON data;
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

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ReturnDataByPageModel{" +
                "statusCode=" + statusCode +
                ", totalPage=" + totalPage +
                ", data=" + data +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
