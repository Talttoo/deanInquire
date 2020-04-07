package com.julong.deanInquire.dto.entity.item;
/**
 * 药品
*/
public class DrugDTO {
    private String stuffId;
    private String stuffCode;
    private String stuffName;

    public String getStuffId() {
        return stuffId;
    }

    public void setStuffId(String stuffId) {
        this.stuffId = stuffId;
    }

    public String getStuffCode() {
        return stuffCode;
    }

    public void setStuffCode(String stuffCode) {
        this.stuffCode = stuffCode;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    @Override
    public String toString() {
        return "DrugDTO{" +
                "stuffId='" + stuffId + '\'' +
                ", stuffCode='" + stuffCode + '\'' +
                ", stuffName='" + stuffName + '\'' +
                '}';
    }
}

