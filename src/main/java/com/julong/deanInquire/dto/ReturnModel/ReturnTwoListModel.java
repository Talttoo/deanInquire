package com.julong.deanInquire.dto.ReturnModel;

import com.alibaba.fastjson.JSON;

public class ReturnTwoListModel {
    private JSON list1;
    private JSON list2;

    public JSON getList1() {
        return list1;
    }

    public void setList1(JSON list1) {
        this.list1 = list1;
    }

    public JSON getList2() {
        return list2;
    }

    public void setList2(JSON list2) {
        this.list2 = list2;
    }

    @Override
    public String toString() {
        return "ReturnTwoListModel{" +
                "list1=" + list1 +
                ", list2=" + list2 +
                '}';
    }
}
