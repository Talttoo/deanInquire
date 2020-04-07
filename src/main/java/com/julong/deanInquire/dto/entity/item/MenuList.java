package com.julong.deanInquire.dto.entity.item;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class MenuList {

    private  long MOID;
    private String MONAME;
    private JSON list;

    public long getMOID() {
        return MOID;
    }

    public void setMOID(long MOID) {
        this.MOID = MOID;
    }

    public String getMONAME() {
        return MONAME;
    }

    public void setMONAME(String MONAME) {
        this.MONAME = MONAME;
    }

    public JSON getList() {
        return list;
    }

    public void setList(JSON list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "MOID=" + MOID +
                ", MONAME='" + MONAME + '\'' +
                ", list=" + list +
                '}';
    }
}
