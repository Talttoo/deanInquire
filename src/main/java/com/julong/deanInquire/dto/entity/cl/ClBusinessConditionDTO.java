package com.julong.deanInquire.dto.entity.cl;

/**
 * //2.	门诊信息
 * //1）	门诊业务状况分析
 */
public class ClBusinessConditionDTO {

    private String dept;//
    private String deptCode;//
    private String deptName;//
    private int clTimes;//
    private double xyFee;//
    private double zyFee;//
    private double ylFee;//
    private double totalFee;//
    private double xyMaxAmount;//
    private double zyMaxAmount;//
    private double ylMaxAmount;//
    private double xyTimes;//
    private double zyTimes;//
    private double ylTimes;//


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public int getClTimes() {
        return clTimes;
    }

    public void setClTimes(int clTimes) {
        this.clTimes = clTimes;
    }

    public double getXyFee() {
        return xyFee;
    }

    public void setXyFee(double xyFee) {
        this.xyFee = xyFee;
    }

    public double getZyFee() {
        return zyFee;
    }

    public void setZyFee(double zyFee) {
        this.zyFee = zyFee;
    }

    public double getYlFee() {
        return ylFee;
    }

    public void setYlFee(double ylFee) {
        this.ylFee = ylFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getXyMaxAmount() {
        return xyMaxAmount;
    }

    public void setXyMaxAmount(double xyMaxAmount) {
        this.xyMaxAmount = xyMaxAmount;
    }

    public double getZyMaxAmount() {
        return zyMaxAmount;
    }

    public void setZyMaxAmount(double zyMaxAmount) {
        this.zyMaxAmount = zyMaxAmount;
    }

    public double getYlMaxAmount() {
        return ylMaxAmount;
    }

    public void setYlMaxAmount(double ylMaxAmount) {
        this.ylMaxAmount = ylMaxAmount;
    }

    public double getXyTimes() {
        return xyTimes;
    }

    public void setXyTimes(double xyTimes) {
        this.xyTimes = xyTimes;
    }

    public double getZyTimes() {
        return zyTimes;
    }

    public void setZyTimes(double zyTimes) {
        this.zyTimes = zyTimes;
    }

    public double getYlTimes() {
        return ylTimes;
    }

    public void setYlTimes(double ylTimes) {
        this.ylTimes = ylTimes;
    }


    @Override
    public String toString() {
        return "ClBusinessConditionDTO{" +
                "dept='" + dept + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", clTimes=" + clTimes +
                ", xyFee=" + xyFee +
                ", zyFee=" + zyFee +
                ", ylFee=" + ylFee +
                ", totalFee=" + totalFee +
                ", xyMaxAmount=" + xyMaxAmount +
                ", zyMaxAmount=" + zyMaxAmount +
                ", ylMaxAmount=" + ylMaxAmount +
                ", xyTimes=" + xyTimes +
                ", zyTimes=" + zyTimes +
                ", ylTimes=" + ylTimes +
                '}';
    }
}
