package com.julong.deanInquire.dto.entity.dean;

/**
 * 当天全院业务动态
 * （返回数据给小程序用）
 */
public class DeNewAllStaffBusinessDTO {

    private int cl_gopTimes;//急诊总人数
    private int cl_erTimes;//门诊总人数
    private int cl_totalTimes;//门急诊总人数


    private double cl_recipeTotalFee;//处方总金额=门诊结算总收入
    private int cl_times;//有效处方数
    private  double cl_perAmount;//人均处方金额

    private double cl_totalFee;//门诊结算总收入
    private double cl_drugFee;//门诊药品结算总收入
    private String  cl_drugInTotal;//药品占总收入比例 ,为了加上百分号，设置String类型

    private int ip_inTimes;//入院人数
    private int ip_existTimes;//在院人数
    private int ip_outTimes;//出院人数


    private int ip_totalBed;//额定床位
    private int ip_useBed;//使用床位
    private String bed_useProportion;//为了加上百分号，设置String类型

    private double ip_totalFee;//住院结算总收入
    private double ip_drugFee;//住院药品结算收入
    private String ip_drugInTotal;//住院：药品占住院总收入

    private double all_totalFee;//全院结算总收入
    private double all_drugFee;//全院药品结算收入
    private String all_drugInTotal;//药品收入占全院收入比例

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

    public int getCl_totalTimes() {
        return cl_totalTimes;
    }

    public void setCl_totalTimes(int cl_totalTimes) {
        this.cl_totalTimes = cl_totalTimes;
    }

    public double getCl_recipeTotalFee() {
        return cl_recipeTotalFee;
    }

    public void setCl_recipeTotalFee(double cl_recipeTotalFee) {
        this.cl_recipeTotalFee = cl_recipeTotalFee;
    }

    public int getCl_times() {
        return cl_times;
    }

    public void setCl_times(int cl_times) {
        this.cl_times = cl_times;
    }

    public double getCl_perAmount() {
        return cl_perAmount;
    }

    public void setCl_perAmount(double cl_perAmount) {
        this.cl_perAmount = cl_perAmount;
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

    public String getCl_drugInTotal() {
        return cl_drugInTotal;
    }

    public void setCl_drugInTotal(String cl_drugInTotal) {
        this.cl_drugInTotal = cl_drugInTotal;
    }

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

    public int getIp_outTimes() {
        return ip_outTimes;
    }

    public void setIp_outTimes(int ip_outTimes) {
        this.ip_outTimes = ip_outTimes;
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

    public String getBed_useProportion() {
        return bed_useProportion;
    }

    public void setBed_useProportion(String bed_useProportion) {
        this.bed_useProportion = bed_useProportion;
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

    public String getIp_drugInTotal() {
        return ip_drugInTotal;
    }

    public void setIp_drugInTotal(String ip_drugInTotal) {
        this.ip_drugInTotal = ip_drugInTotal;
    }

    public double getAll_totalFee() {
        return all_totalFee;
    }

    public void setAll_totalFee(double all_totalFee) {
        this.all_totalFee = all_totalFee;
    }

    public double getAll_drugFee() {
        return all_drugFee;
    }

    public void setAll_drugFee(double all_drugFee) {
        this.all_drugFee = all_drugFee;
    }

    public String getAll_drugInTotal() {
        return all_drugInTotal;
    }

    public void setAll_drugInTotal(String all_drugInTotal) {
        this.all_drugInTotal = all_drugInTotal;
    }

    @Override
    public String toString() {
        return "DeNewAllStaffBusinessDTO{" +
                "cl_gopTimes=" + cl_gopTimes +
                ", cl_erTimes=" + cl_erTimes +
                ", cl_totalTimes=" + cl_totalTimes +
                ", cl_recipeTotalFee=" + cl_recipeTotalFee +
                ", cl_times=" + cl_times +
                ", cl_perAmount=" + cl_perAmount +
                ", cl_totalFee=" + cl_totalFee +
                ", cl_drugFee=" + cl_drugFee +
                ", cl_drugInTotal='" + cl_drugInTotal + '\'' +
                ", ip_inTimes=" + ip_inTimes +
                ", ip_existTimes=" + ip_existTimes +
                ", ip_outTimes=" + ip_outTimes +
                ", ip_totalBed=" + ip_totalBed +
                ", ip_useBed=" + ip_useBed +
                ", bed_useProportion='" + bed_useProportion + '\'' +
                ", ip_totalFee=" + ip_totalFee +
                ", ip_drugFee=" + ip_drugFee +
                ", ip_drugInTotal='" + ip_drugInTotal + '\'' +
                ", all_totalFee=" + all_totalFee +
                ", all_drugFee=" + all_drugFee +
                ", all_drugInTotal='" + all_drugInTotal + '\'' +
                '}';
    }
}
