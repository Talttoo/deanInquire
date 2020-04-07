package com.julong.deanInquire.dto.inpram.cl;

/**
 * 大处方查询入参
 */
public class BigPrescriptionQueryPramBean {

    private String startTime;//开始时间
    private String endTIme;//结束时间
    private int amount;
    private String doctorId;
    private String deptId;//选择科室的ID
    private String cataId;//选择处方分类的ID

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startingTime) {
        this.startTime = startingTime;
    }

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCataId() {
        return cataId;
    }

    public void setCataId(String cataId) {
        this.cataId = cataId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "BigPrescriptionQueryPramBean{" +
                "startTime='" + startTime + '\'' +
                ", endTIme='" + endTIme + '\'' +
                ", amount=" + amount +
                ", doctorId='" + doctorId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", cataId='" + cataId + '\'' +
                '}';
    }
}
