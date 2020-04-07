package com.julong.deanInquire.dto.entity.ip;

/**
 * 住院药品收入比例（返回数据给小程序用）
 */
public class New_IpDrugRevenueRatioDTO {

    private String deptCode;
    private String deptName;
    private double totalSum;
    private double drugFee;
    private String drugFeeInDept;//药品占科室收入比例
    private String drugFeeInIp;//药品占住院收入比例

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

    public String getDrugFeeInDept() {
        return drugFeeInDept;
    }

    public void setDrugFeeInDept(String drugFeeInDept) {
        this.drugFeeInDept = drugFeeInDept;
    }

    public String getDrugFeeInIp() {
        return drugFeeInIp;
    }

    public void setDrugFeeInIp(String drugFeeInIp) {
        this.drugFeeInIp = drugFeeInIp;
    }

    @Override
    public String toString() {
        return "New_IpDrugRevenueRatioDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", totalSum=" + totalSum +
                ", drugFee=" + drugFee +
                ", drugFeeInDept='" + drugFeeInDept + '\'' +
                ", drugFeeInIp='" + drugFeeInIp + '\'' +
                '}';
    }
}
