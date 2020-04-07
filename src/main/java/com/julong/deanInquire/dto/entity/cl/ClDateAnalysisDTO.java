package com.julong.deanInquire.dto.entity.cl;

/**
 * 门诊量分析-日期分析
 */
public class ClDateAnalysisDTO {
     private String regdate;
     private int clTimes;

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getClTimes() {
        return clTimes;
    }

    public void setClTimes(int clTimes) {
        this.clTimes = clTimes;
    }

    @Override
    public String toString() {
        return "ClDateAnalysisDTO{" +
                "regdate='" + regdate + '\'' +
                ", clTimes=" + clTimes +
                '}';
    }
}
