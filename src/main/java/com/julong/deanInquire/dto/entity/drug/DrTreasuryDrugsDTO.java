package com.julong.deanInquire.dto.entity.drug;
/**
* 3）	库房药品入库排行榜
*/
public class DrTreasuryDrugsDTO {
    private String itemCode;
    private String itemName;
    private String unitName;
    private int quantity;
    private double amount;
    /*private String startingTime;//开始时间
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
        return "DrTreasuryDrugsDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
