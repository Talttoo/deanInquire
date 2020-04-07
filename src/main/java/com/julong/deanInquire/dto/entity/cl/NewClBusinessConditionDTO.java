package com.julong.deanInquire.dto.entity.cl;

public class NewClBusinessConditionDTO {

    private String dept;//
    private String deptCode;//
    private String deptName;//
    //综合信息
    private int clTimes;//
    private double totalFee;//
    private double avgFee;//

    //病人总费用
    private double xyFee;//
    private double zyFee;//
    private double ylFee;//

    //处方数
    private double xyTimes;//
    private double zyTimes;//
    private double ylTimes;//

    //病人平均费用
    private double avgXyFee;//
    private double avgZyFee;//
    private double avgYlFee;//

    //最大处方
    private double xyMaxAmount;//
    private double zyMaxAmount;//
    private double ylMaxAmount;//

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

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getAvgFee() {
        return avgFee;
    }

    public void setAvgFee(double avgFee) {
        this.avgFee = avgFee;
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

    public double getAvgXyFee() {
        return avgXyFee;
    }

    public void setAvgXyFee(double avgXyFee) {
        this.avgXyFee = avgXyFee;
    }

    public double getAvgZyFee() {
        return avgZyFee;
    }

    public void setAvgZyFee(double avgZyFee) {
        this.avgZyFee = avgZyFee;
    }

    public double getAvgYlFee() {
        return avgYlFee;
    }

    public void setAvgYlFee(double avgYlFee) {
        this.avgYlFee = avgYlFee;
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

    @Override
    public String toString() {
        return "NewClBusinessConditionDTO{" +
                "dept='" + dept + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", clTimes=" + clTimes +
                ", totalFee=" + totalFee +
                ", avgFee=" + avgFee +
                ", xyFee=" + xyFee +
                ", zyFee=" + zyFee +
                ", ylFee=" + ylFee +
                ", xyTimes=" + xyTimes +
                ", zyTimes=" + zyTimes +
                ", ylTimes=" + ylTimes +
                ", avgXyFee=" + avgXyFee +
                ", avgZyFee=" + avgZyFee +
                ", avgYlFee=" + avgYlFee +
                ", xyMaxAmount=" + xyMaxAmount +
                ", zyMaxAmount=" + zyMaxAmount +
                ", ylMaxAmount=" + ylMaxAmount +
                '}';
    }
}
