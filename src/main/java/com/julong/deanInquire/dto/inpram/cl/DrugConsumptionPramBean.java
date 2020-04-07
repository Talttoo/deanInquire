package com.julong.deanInquire.dto.inpram.cl;

/**
 *门诊药品消耗趋势分析查询入参
 */
public class DrugConsumptionPramBean {

    private String startTime;//开始时间
    private String endTIme;//结束时间
    private String itemId ;//选择药品分类的ID

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "DrugConsumptionPramBean{" +
                "startTime='" + startTime + '\'' +
                ", endTIme='" + endTIme + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
