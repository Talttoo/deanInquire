package com.julong.deanInquire.dto.entity.cl;

/**
 * 门诊量分析-性别分析
 */
public class ClGenderAnalysisDTO {
    private String sex;
    private int clTimes;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getClTimes() {
        return clTimes;
    }

    public void setClTimes(int clTimes) {
        this.clTimes = clTimes;
    }

    @Override
    public String toString() {
        return "ClGenderAnalysisDTO{" +
                "sex='" + sex + '\'' +
                ", clTimes='" + clTimes + '\'' +
                '}';
    }
}
