package com.julong.deanInquire.dto.entity.ip;

/**
 * 住院药品合计数据
 */
public class DrugRevenueSumDTO {
    private double totalFee;
    private double drugFee;
    private String drugFeeProportion;

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getDrugFee() {
        return drugFee;
    }

    public void setDrugFee(double drugFee) {
        this.drugFee = drugFee;
    }

    public String getDrugFeeProportion() {
        return drugFeeProportion;
    }

    public void setDrugFeeProportion(String drugFeeProportion) {
        this.drugFeeProportion = drugFeeProportion;
    }

    @Override
    public String toString() {
        return "DrugRevenueSumDTO{" +
                "totalFee=" + totalFee +
                ", drugFee=" + drugFee +
                ", drugFeeProportion='" + drugFeeProportion + '\'' +
                '}';
    }
}
