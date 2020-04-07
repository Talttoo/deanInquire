package com.julong.deanInquire.dto.entity.item;
/**
 * 选择处方分类
*/
public class PrescriptionClassificationDTO {
    private String cataId;
    private String cataCode;
    private String cataName;

    public String getCataId() {
        return cataId;
    }

    public void setCataId(String cataId) {
        this.cataId = cataId;
    }

    public String getCataCode() {
        return cataCode;
    }

    public void setCataCode(String cataCode) {
        this.cataCode = cataCode;
    }

    public String getCataName() {
        return cataName;
    }

    public void setCataName(String cataName) {
        this.cataName = cataName;
    }

    @Override
    public String toString() {
        return "PrescriptionClassificationDTO{" +
                "cataId='" + cataId + '\'' +
                ", cataCode='" + cataCode + '\'' +
                ", cataName='" + cataName + '\'' +
                '}';
    }
}
