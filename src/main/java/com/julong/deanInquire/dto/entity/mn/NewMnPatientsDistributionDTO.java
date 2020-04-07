package com.julong.deanInquire.dto.entity.mn;

public class NewMnPatientsDistributionDTO {
    private String deptCode;
    private String deptName;
    private int inTimes;
    private String proportion;

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

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        return "NewMnPatientsDistributionDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", inTimes=" + inTimes +
                ", proportion='" + proportion + '\'' +
                '}';
    }
}
