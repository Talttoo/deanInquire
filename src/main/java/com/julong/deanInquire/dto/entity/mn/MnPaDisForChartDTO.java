package com.julong.deanInquire.dto.entity.mn;

public class MnPaDisForChartDTO {
    private String name;
    private int data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MnPaDisForChartDTO{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
