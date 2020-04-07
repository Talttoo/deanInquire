package com.julong.deanInquire.dto.entity.ip;
/**
* 2）	住院药品收入比例
*/
public class IpDrugRevenueRatioDTO {
    private String deptCode;
    private String deptName;
    private double totalSum;
    private double drugFee;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getDrugFee() {
        return drugFee;
    }

    public void setDrugFee(double drugFee) {
        this.drugFee = drugFee;
    }

    @Override
    public String toString() {
        return "IpDrugRevenueRatioDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", totalSum=" + totalSum +
                ", drugFee=" + drugFee +
                '}';
    }
}
