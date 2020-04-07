package com.julong.deanInquire.dto.entity.ip;
/**
* //3.	住院信息
*    //1）	住院结算收入分析图
*/
public class IpSettlementIncomeDTO {

    private String chargeTime;
    private String chargeDay;
    private double totalSum;

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChargeDay() {
        return chargeDay;
    }

    public void setChargeDay(String chargeDay) {
        this.chargeDay = chargeDay;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "IpSettlementIncomeDTO{" +
                "chargeTime='" + chargeTime + '\'' +
                ", chargeDay='" + chargeDay + '\'' +
                ", totalSum=" + totalSum +
                '}';
    }
}
