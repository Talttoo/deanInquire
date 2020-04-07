package com.julong.deanInquire.dto.inpram.cl;

public class DrugStatisticsPramBean {

    private String startTime;//开始时间
    private String endTIme;//结束时间
    private int statisticType;//统计类型 1：药品  2：国产药 3：进口药 4：抗生素
    private String order;//排序类型

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }

    public int getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(int statisticType) {
        this.statisticType = statisticType;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "DrugStatisticsPramBean{" +
                "startTime='" + startTime + '\'' +
                ", endTIme='" + endTIme + '\'' +
                ", statisticType='" + statisticType + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
