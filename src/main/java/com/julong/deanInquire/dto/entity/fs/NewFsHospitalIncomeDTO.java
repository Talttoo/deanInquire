package com.julong.deanInquire.dto.entity.fs;

public class NewFsHospitalIncomeDTO {
    private String deptCode;
    private String deptName;
    private double total;
    private String proportion;

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

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        return "NewFsHospitalIncomeDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", total=" + total +
                ", proportion='" + proportion + '\'' +
                '}';
    }
}
