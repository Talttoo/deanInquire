package com.julong.deanInquire.dto.entity.fs;
/**
* //2）	出院病人欠款坏账分析
*/
public class FsPatientArrearsDTO {

    private String deptCode;
    private String deptName;
    private double total;
    private double deposit;


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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "FsPatientArrearsDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", total=" + total +
                ", deposit=" + deposit +
                '}';
    }
}
