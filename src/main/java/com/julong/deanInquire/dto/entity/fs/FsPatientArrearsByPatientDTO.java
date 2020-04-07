package com.julong.deanInquire.dto.entity.fs;

public class FsPatientArrearsByPatientDTO {
    private String  encounterID;
    private String  ipNo;
    private int ipCount;
    private String  name;
    private String inDate;
    private String outDate;
    private String  deptName ;
	private double  total ;
    private  double deposit;
    private double badDebt;

    public String getEncounterID() {
        return encounterID;
    }

    public void setEncounterID(String encounterID) {
        this.encounterID = encounterID;
    }

    public String getIpNo() {
        return ipNo;
    }

    public void setIpNo(String ipNo) {
        this.ipNo = ipNo;
    }

    public int getIpCount() {
        return ipCount;
    }

    public void setIpCount(int ipCount) {
        this.ipCount = ipCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getBadDebt() {
        return badDebt;
    }

    public void setBadDebt(double badDebt) {
        this.badDebt = badDebt;
    }

    @Override
    public String toString() {
        return "FsPatientArrearsByPatientDTO{" +
                "encounterID='" + encounterID + '\'' +
                ", ipNo='" + ipNo + '\'' +
                ", ipCount=" + ipCount +
                ", name='" + name + '\'' +
                ", inDate='" + inDate + '\'' +
                ", outDate='" + outDate + '\'' +
                ", deptName='" + deptName + '\'' +
                ", total=" + total +
                ", deposit=" + deposit +
                ", badDebt=" + badDebt +
                '}';
    }
}
