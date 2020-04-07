package com.julong.deanInquire.dto.entity.mt;
/**
 *
* 2）	科室医技工作量
*/
public class MtDeptMedicalWorkDTO {
    private String ipclType;
    private String deptId;
    private String deptCode;
    private String deptName;
    private int jcTimes;
    private int hyTimes;
    private double jcAmount;
    private double hyAmount;
    /*private String startingTime;//开始时间
    private String endTIme;//结束时间*/

    public String getIpclType() {
        return ipclType;
    }

    public void setIpclType(String ipclType) {
        this.ipclType = ipclType;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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

    public int getJcTimes() {
        return jcTimes;
    }

    public void setJcTimes(int jcTimes) {
        this.jcTimes = jcTimes;
    }

    public int getHyTimes() {
        return hyTimes;
    }

    public void setHyTimes(int hyTimes) {
        this.hyTimes = hyTimes;
    }

    public double getJcAmount() {
        return jcAmount;
    }

    public void setJcAmount(double jcAmount) {
        this.jcAmount = jcAmount;
    }

    public double getHyAmount() {
        return hyAmount;
    }

    public void setHyAmount(double hyAmount) {
        this.hyAmount = hyAmount;
    }

    @Override
    public String toString() {
        return "MtDeptMedicalWorkDTO{" +
                "ipclType='" + ipclType + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", jcTimes=" + jcTimes +
                ", hyTimes=" + hyTimes +
                ", jcAmount=" + jcAmount +
                ", hyAmount=" + hyAmount +
                '}';
    }
}

