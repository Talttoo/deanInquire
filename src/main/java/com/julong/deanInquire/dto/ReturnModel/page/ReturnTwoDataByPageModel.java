package com.julong.deanInquire.dto.ReturnModel.page;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.objects.annotations.Getter;
/**
 * 返回两个data的带分页JSON
 */
public class ReturnTwoDataByPageModel {
    private Integer statusCode  ;
    private Integer totalPage  ;
    private JSON data;
    private JSON data_2;
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

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ReturnTwoDataByPageModel{" +
                "statusCode=" + statusCode +
                ", totalPage=" + totalPage +
                ", data=" + data +
                ", data_2=" + data_2 +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
