package com.julong.deanInquire.dto.entity.dean;
/**
 * 1）	当天全员业务动态
 */

public class DeAllStaffBusinessDTO {

    private int ip_inTimes;//入院人数
    private int ip_existTimes;//在院人数
    private int ip_totalBed;//额定床位
    private int ip_useBed;//使用床位
    private int ip_outTimes;//出院人数
    private int cl_gopTimes;//急诊总人数
    private int cl_erTimes;//门诊总人数
    private double ip_totalFee;//住院结算总收入
    private double ip_drugFee;//住院药品结算收入
    private int cl_times;//接诊人数
    private double cl_totalFee;//门诊结算总收入
    private double cl_drugFee;//门诊药品结算总收入

    public int getIp_inTimes() {
        return ip_inTimes;
    }

    public void setIp_inTimes(int ip_inTimes) {
        this.ip_inTimes = ip_inTimes;
    }

    public int getIp_existTimes() {
        return ip_existTimes;
    }

    public void setIp_existTimes(int ip_existTimes) {
        this.ip_existTimes = ip_existTimes;
    }

    public int getIp_totalBed() {
        return ip_totalBed;
    }

    public void setIp_totalBed(int ip_totalBed) {
        this.ip_totalBed = ip_totalBed;
    }

    public int getIp_useBed() {
        return ip_useBed;
    }

    public void setIp_useBed(int ip_useBed) {
        this.ip_useBed = ip_useBed;
    }

    public int getIp_outTimes() {
        return ip_outTimes;
    }

    public void setIp_outTimes(int ip_outTimes) {
        this.ip_outTimes = ip_outTimes;
    }

    public int getCl_gopTimes() {
        return cl_gopTimes;
    }

    public void setCl_gopTimes(int cl_gopTimes) {
        this.cl_gopTimes = cl_gopTimes;
    }

    public int getCl_erTimes() {
        return cl_erTimes;
    }

    public void setCl_erTimes(int cl_erTimes) {
        this.cl_erTimes = cl_erTimes;
    }

    public double getIp_totalFee() {
        return ip_totalFee;
    }

    public void setIp_totalFee(double ip_totalFee) {
        this.ip_totalFee = ip_totalFee;
    }

    public double getIp_drugFee() {
        return ip_drugFee;
    }

    public void setIp_drugFee(double ip_drugFee) {
        this.ip_drugFee = ip_drugFee;
    }

    public int getCl_times() {
        return cl_times;
    }

    public void setCl_times(int cl_times) {
        this.cl_times = cl_times;
    }

    public double getCl_totalFee() {
        return cl_totalFee;
    }

    public void setCl_totalFee(double cl_totalFee) {
        this.cl_totalFee = cl_totalFee;
    }

    public double getCl_drugFee() {
        return cl_drugFee;
    }

    public void setCl_drugFee(double cl_drugFee) {
        this.cl_drugFee = cl_drugFee;
    }

    @Override
    public String toString() {
        return "DeAllStaffBusinessDTO{" +
                "ip_inTimes=" + ip_inTimes +
                ", ip_existTimes=" + ip_existTimes +
                ", ip_totalBed=" + ip_totalBed +
                ", ip_useBed=" + ip_useBed +
                ", ip_outTimes=" + ip_outTimes +
                ", cl_gopTimes=" + cl_gopTimes +
                ", cl_erTimes=" + cl_erTimes +
                ", ip_totalFee=" + ip_totalFee +
                ", ip_drugFee=" + ip_drugFee +
                ", cl_times=" + cl_times +
                ", cl_totalFee=" + cl_totalFee +
                ", cl_drugFee=" + cl_drugFee +
                '}';
    }
}
