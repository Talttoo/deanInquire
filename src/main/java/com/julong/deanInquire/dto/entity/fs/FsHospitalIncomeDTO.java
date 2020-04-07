package com.julong.deanInquire.dto.entity.fs;
/**
*    7.	财务状况
*   1）	全院收入分析
*/
public class FsHospitalIncomeDTO {
    private String deptCode;
    private String deptName;
    private double total;
    //private int type;//全院/门诊/住院
    /*private String startingTime;//开始时间
    private String endTIme;//结束时间*/

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



    @Override
    public String toString() {
        return "FsHospitalIncomeDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", total=" + total +
                '}';
    }
}
