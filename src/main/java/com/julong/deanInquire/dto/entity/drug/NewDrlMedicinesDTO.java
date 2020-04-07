package com.julong.deanInquire.dto.entity.drug;

public class NewDrlMedicinesDTO {
    private String deptCode;
    private String deptName;
    private String doctorCode;
    private String doctorName;
    private double antibacterialFee;
    private double genericFee;
    private double total;
    private String antibacterialFeeInTotal;
    private String genericFeeInTotal;

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

    public String getAntibacterialFeeInTotal() {
        return antibacterialFeeInTotal;
    }

    public void setAntibacterialFeeInTotal(String antibacterialFeeInTotal) {
        this.antibacterialFeeInTotal = antibacterialFeeInTotal;
    }

    public String getGenericFeeInTotal() {
        return genericFeeInTotal;
    }

    public void setGenericFeeInTotal(String genericFeeInTotal) {
        this.genericFeeInTotal = genericFeeInTotal;
    }

    @Override
    public String toString() {
        return "NewDrlMedicinesDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", doctorCode='" + doctorCode + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", antibacterialFee=" + antibacterialFee +
                ", genericFee=" + genericFee +
                ", total=" + total +
                ", antibacterialFeeInTotal=" + antibacterialFeeInTotal +
                ", genericFeeInTotal=" + genericFeeInTotal +
                '}';
    }
}
