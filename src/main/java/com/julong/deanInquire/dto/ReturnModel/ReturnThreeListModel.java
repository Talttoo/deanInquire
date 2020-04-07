package com.julong.deanInquire.dto.ReturnModel;

import com.alibaba.fastjson.JSON;

public class ReturnThreeListModel {
    private JSON list1;
    private JSON list2;
    private JSON list3;

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

    public JSON getList3() {
        return list3;
    }

    public void setList3(JSON list3) {
        this.list3 = list3;
    }

    @Override
    public String toString() {
        return "ReturnThreeListModel{" +
                "list1=" + list1 +
                ", list2=" + list2 +
                ", list3=" + list3 +
                '}';
    }
}
