package com.julong.deanInquire.dto.entity.cl;
/**
* 5）	门诊量分析-科室分析
*/
public class ClVolumeAnalysisDTO {
    private int clTimes;
    private String deptCode;
    private String deptName;

    public int getClTimes() {
        return clTimes;
    }

    public void setClTimes(int clTimes) {
        this.clTimes = clTimes;
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

    @Override
    public String toString() {
        return "ClVolumeAnalysisDTO{" +
                "clTimes=" + clTimes +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
