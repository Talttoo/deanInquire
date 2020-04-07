package com.julong.deanInquire.dto.entity.drug;

/**
 * 药品费用数据（返回数据给小程序用）
 */
public class DrugsFeeDataDTO {
    private double clDrugFee;
    private double ipDrugFee;
    private double totalDrugFee;

    public double getClDrugFee() {
        return clDrugFee;
    }

    public void setClDrugFee(double clDrugFee) {
        this.clDrugFee = clDrugFee;
    }

    public double getIpDrugFee() {
        return ipDrugFee;
    }

    public void setIpDrugFee(double ipDrugFee) {
        this.ipDrugFee = ipDrugFee;
    }

    public double getTotalDrugFee() {
        return totalDrugFee;
    }

    public void setTotalDrugFee(double totalDrugFee) {
        this.totalDrugFee = totalDrugFee;
    }

    @Override
    public String toString() {
        return "DrugsFeeDataDTO{" +
                "clDrugFee=" + clDrugFee +
                ", ipDrugFee=" + ipDrugFee +
                ", totalDrugFee=" + totalDrugFee +
                '}';
    }
}
