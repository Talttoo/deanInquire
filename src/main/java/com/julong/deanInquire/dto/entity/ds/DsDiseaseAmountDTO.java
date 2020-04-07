package com.julong.deanInquire.dto.entity.ds;
/**
* //疾病金额人次分析
*/
public class DsDiseaseAmountDTO {

    private int rowNum;
    private String diagName;
    private int times;
    private double total;
    /*private String startingTime;//开始时间
    private String endTIme;//结束时间*/

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

    @Override
    public String toString() {
        return "DsDiseaseAmountDTO{" +
                "rowNum=" + rowNum +
                ", diagName='" + diagName + '\'' +
                ", times=" + times +
                ", total=" + total +
                '}';
    }
}
