package com.julong.deanInquire.dto.entity.mn;
/**
 *  6.	医疗动态
*  1）	在院病人分布情况
*/
public class MnPatientsDistributionDTO {

    private String deptCode;
    private String deptName;
    private int inTimes;

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

    public int getInTimes() {
        return inTimes;
    }

    public void setInTimes(int inTimes) {
        this.inTimes = inTimes;
    }

    @Override
    public String toString() {
        return "MnPatientsDistributionDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", inTimes=" + inTimes +
                '}';
    }
}
