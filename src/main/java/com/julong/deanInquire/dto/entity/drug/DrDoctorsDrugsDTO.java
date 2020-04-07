package com.julong.deanInquire.dto.entity.drug;
/**
*     4.药品信息
*    1）医生药品金额排行榜
*/
public class DrDoctorsDrugsDTO {

    private String doctorCode;
    private String doctorName;
    private double clTotal;
    private double ipTotal;
    private double total;



    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public double getClTotal() {
        return clTotal;
    }

    public void setClTotal(double clTotal) {
        this.clTotal = clTotal;
    }

    public double getIpTotal() {
        return ipTotal;
    }

    public void setIpTotal(double ipTotal) {
        this.ipTotal = ipTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DrDoctorsDrugsDTO{" +
                "doctorCode='" + doctorCode + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", clTotal=" + clTotal +
                ", ipTotal=" + ipTotal +
                ", total=" + total +
                '}';
    }
}
