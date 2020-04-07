package com.julong.deanInquire.dto.entity.drug;

public class NewDrTreasuryDrugsDTO {
    private int rowCount;
    private String itemCode;
    private String itemName;
    private String unitName;
    private int quantity;
    private double amount;

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

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
        return "NewDrTreasuryDrugsDTO{" +
                "rowCount=" + rowCount +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
