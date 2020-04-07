package com.julong.deanInquire.dto.entity.cl;
/**
*  //2）	门诊大处方查询
 */

public class ClBigPrescriptionQueryDTO {

    private String recipeId;
    private String cataName;
    private String name;
    private String deptCode;
    private String deptName;
    private String doctorCode;
    private String doctorName;
    private String inputTime;
    private double amount;
    private String deptId;//选择科室的ID
    private String cataId;//选择处方分类的ID

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getCataName() {
        return cataName;
    }

    public void setCataName(String cataName) {
        this.cataName = cataName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCataId() {
        return cataId;
    }

    public void setCataId(String cataId) {
        this.cataId = cataId;
    }

    @Override
    public String toString() {
        return "ClBigPrescriptionQueryDTO{" +
                "recipeId='" + recipeId + '\'' +
                ", cataName='" + cataName + '\'' +
                ", name='" + name + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", doctorCode='" + doctorCode + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", inputTime='" + inputTime + '\'' +
                ", amount=" + amount +
                ", deptId='" + deptId + '\'' +
                ", cataId='" + cataId + '\'' +
                '}';
    }
}
