package com.julong.deanInquire.dto.entity.ds;
/**8.	疾病分析
*1）	疾病年龄段分析
*/
public class DsDiseaseAgeDTO {

    private int rowNum;
    private String diagName;
    private int times;
    private int zeroToNine;
    private int tenToNineteen;
    private int twentyToTwentyNine;
    private int thirtyToThirtyNine;
    private int fortyToFortyNine;
    private int fiftyToFiftyNine;
    private int sixtyToSixtyNine;
    private int seventyToSeventyNine;
    private int eightyToEightyNine;
    private int ninetyToNinetyNine;
    private int hundred;

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

    public int getZeroToNine() {
        return zeroToNine;
    }

    public void setZeroToNine(int zeroToNine) {
        this.zeroToNine = zeroToNine;
    }

    public int getTenToNineteen() {
        return tenToNineteen;
    }

    public void setTenToNineteen(int tenToNineteen) {
        this.tenToNineteen = tenToNineteen;
    }

    public int getTwentyToTwentyNine() {
        return twentyToTwentyNine;
    }

    public void setTwentyToTwentyNine(int twentyToTwentyNine) {
        this.twentyToTwentyNine = twentyToTwentyNine;
    }

    public int getThirtyToThirtyNine() {
        return thirtyToThirtyNine;
    }

    public void setThirtyToThirtyNine(int thirtyToThirtyNine) {
        this.thirtyToThirtyNine = thirtyToThirtyNine;
    }

    public int getFortyToFortyNine() {
        return fortyToFortyNine;
    }

    public void setFortyToFortyNine(int fortyToFortyNine) {
        this.fortyToFortyNine = fortyToFortyNine;
    }

    public int getFiftyToFiftyNine() {
        return fiftyToFiftyNine;
    }

    public void setFiftyToFiftyNine(int fiftyToFiftyNine) {
        this.fiftyToFiftyNine = fiftyToFiftyNine;
    }

    public int getSixtyToSixtyNine() {
        return sixtyToSixtyNine;
    }

    public void setSixtyToSixtyNine(int sixtyToSixtyNine) {
        this.sixtyToSixtyNine = sixtyToSixtyNine;
    }

    public int getSeventyToSeventyNine() {
        return seventyToSeventyNine;
    }

    public void setSeventyToSeventyNine(int seventyToSeventyNine) {
        this.seventyToSeventyNine = seventyToSeventyNine;
    }

    public int getEightyToEightyNine() {
        return eightyToEightyNine;
    }

    public void setEightyToEightyNine(int eightyToEightyNine) {
        this.eightyToEightyNine = eightyToEightyNine;
    }

    public int getNinetyToNinetyNine() {
        return ninetyToNinetyNine;
    }

    public void setNinetyToNinetyNine(int ninetyToNinetyNine) {
        this.ninetyToNinetyNine = ninetyToNinetyNine;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    @Override
    public String toString() {
        return "DsDiseaseAgeDTO{" +
                "rowNum=" + rowNum +
                ", diagName='" + diagName + '\'' +
                ", times=" + times +
                ", zeroToNine=" + zeroToNine +
                ", tenToNineteen=" + tenToNineteen +
                ", twentyToTwentyNine=" + twentyToTwentyNine +
                ", thirtyToThirtyNine=" + thirtyToThirtyNine +
                ", fortyToFortyNine=" + fortyToFortyNine +
                ", fiftyToFiftyNine=" + fiftyToFiftyNine +
                ", sixtyToSixtyNine=" + sixtyToSixtyNine +
                ", seventyToSeventyNine=" + seventyToSeventyNine +
                ", eightyToEightyNine=" + eightyToEightyNine +
                ", ninetyToNinetyNine=" + ninetyToNinetyNine +
                ", hundred=" + hundred +
                '}';
    }
}
