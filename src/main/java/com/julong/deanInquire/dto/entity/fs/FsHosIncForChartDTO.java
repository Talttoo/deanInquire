package com.julong.deanInquire.dto.entity.fs;

public class FsHosIncForChartDTO {
    private String name;
    private double data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FsHosIncForChartDTO{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
