package com.julong.deanInquire.dto.ReturnModel;

import com.alibaba.fastjson.JSON;

public class ReturnFiveListModel {
    private JSON list1;
    private JSON list2;
    private JSON list3;
    private JSON list4;
    private JSON list5;

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

    public JSON getList4() {
        return list4;
    }

    public void setList4(JSON list4) {
        this.list4 = list4;
    }

    public JSON getList5() {
        return list5;
    }

    public void setList5(JSON list5) {
        this.list5 = list5;
    }

    @Override
    public String toString() {
        return "ReturnFiveListModel{" +
                "list1=" + list1 +
                ", list2=" + list2 +
                ", list3=" + list3 +
                ", list4=" + list4 +
                ", list5=" + list5 +
                '}';
    }
}
