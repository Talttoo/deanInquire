package com.julong.deanInquire.dto.entity.fs;

public class NewPatientArrearsDTO {
    private String deptCode;
    private String deptName;
    private double total;
    private double deposit;
    private double balanceOrArrears;
    private double badDebt;

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

    public double getBalanceOrArrears() {
        return balanceOrArrears;
    }

    public void setBalanceOrArrears(double balanceOrArrears) {
        this.balanceOrArrears = balanceOrArrears;
    }

    public double getBadDebt() {
        return badDebt;
    }

    public void setBadDebt(double badDebt) {
        this.badDebt = badDebt;
    }

    @Override
    public String toString() {
        return "NewPatientArrearsDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", total=" + total +
                ", deposit=" + deposit +
                ", balanceOrArrears=" + balanceOrArrears +
                ", badDebt=" + badDebt +
                '}';
    }
}
