package com.julong.deanInquire.dto.entity.dean;

/**
 *2）	门诊人次每日动态
 */
public class DeClDailyDynamicsDTO {

    private String  gopTimes;//
    private String erTimes;//
    private String hour;//
    private String regDate;
  /*  private String startingTime;//开始时间
    private String endTIme;//结束时间*/

    public String getGopTimes() {
        return gopTimes;
    }

    public void setGopTimes(String gopTimes) {
        this.gopTimes = gopTimes;
    }

    public String getErTimes() {
        return erTimes;
    }

    public void setErTimes(String erTimes) {
        this.erTimes = erTimes;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

   /* public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }*/

    @Override
    public String toString() {
        return "DeClDailyDynamicsDTO{" +
                "gopTimes=" + gopTimes +
                ", erTimes=" + erTimes +
                ", hour=" + hour +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
