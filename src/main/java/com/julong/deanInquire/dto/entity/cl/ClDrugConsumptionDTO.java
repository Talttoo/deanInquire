package com.julong.deanInquire.dto.entity.cl;

/**
 * 门诊药品消耗趋势分析
 */
public class ClDrugConsumptionDTO {
    private String itemCode;
    private String itemName;
    private String standard;
    private String unitName;
    private int quantity;
    private double amount;
    private String chargeTime;
    //private String itemId ;//选择药品分类的ID


    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
    }

    @Override
    public String toString() {
        return "ClDrugConsumptionDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", standard='" + standard + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", chargeTime='" + chargeTime + '\'' +
                '}';
    }
}
