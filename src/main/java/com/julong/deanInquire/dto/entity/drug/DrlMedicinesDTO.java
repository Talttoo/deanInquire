package com.julong.deanInquire.dto.entity.drug;
/**
* 4）	抗生素和基本药品使用分析
*/
public class DrlMedicinesDTO {

    private String deptCode;
    private String deptName;
    private String doctorCode;
    private String doctorName;
    private double antibacterialFee;
    private double genericFee;
    private double total;

   /* private String startingTime;//开始时间
    private String endTIme;//结束时间*/

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

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public double getAntibacterialFee() {
        return antibacterialFee;
    }

    public void setAntibacterialFee(double antibacterialFee) {
        this.antibacterialFee = antibacterialFee;
    }

    public double getGenericFee() {
        return genericFee;
    }

    public void setGenericFee(double genericFee) {
        this.genericFee = genericFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DrlMedicinesDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", doctorCode='" + doctorCode + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", antibacterialFee=" + antibacterialFee +
                ", genericFee=" + genericFee +
                ", total=" + total +
                '}';
    }
}
