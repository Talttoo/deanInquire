package com.julong.deanInquire.dto.entity.ip;
/*
* 各科室住院结算收入分析
* */
public class IpSettlementIncomeByDeptDTO {

    private String deptCode;
    private String deptName;
    private double totalSum;

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

    @Override
    public String toString() {
        return "IpSettlementIncomeByDeptDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", totalSum=" + totalSum +
                '}';
    }
}
