package com.julong.deanInquire.dto.entity.ds;

/**
 * 疾病人次金额分析(返回数据给小程序用)
 */
public class New_DsDiseaseAmountDTO {
    private int rowNum;
    private String diagName;
    private int times;
    private double total;
    private double avgAmount;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getDiagName() {
        return diagName;
    }

    public void setDiagName(String diagName) {
        this.diagName = diagName;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(double avgAmount) {
        this.avgAmount = avgAmount;
    }

    @Override
    public String toString() {
        return "New_DsDiseaseAmountDTO{" +
                "rowNum=" + rowNum +
                ", diagName='" + diagName + '\'' +
                ", times=" + times +
                ", total=" + total +
                ", avgAmount=" + avgAmount +
                '}';
    }
}
