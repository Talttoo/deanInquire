package com.julong.deanInquire.dto.entity.drug;
/**
* //5）	药房药品消耗排行榜
*/
public class DrDrugConsumptionDTO {
    private String itemCode;
    private String itemName;
    private String standard;
    private String unitName;
    private int quantity;
    private double amount;
   /* private String startingTime;//开始时间
    private String endTIme;//结束时间*/

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

    @Override
    public String toString() {
        return "DrDrugConsumptionDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", standard='" + standard + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
