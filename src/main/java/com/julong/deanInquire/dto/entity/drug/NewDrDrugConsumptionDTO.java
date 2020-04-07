package com.julong.deanInquire.dto.entity.drug;

public class NewDrDrugConsumptionDTO {
    private int rowCount;
    private String itemCode;
    private String itemName;
    private String standard;
    private String unitName;
    private int quantity;
    private double amount;
    private String proportion;

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

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        return "NewDrDrugConsumptionDTO{" +
                "rowCount=" + rowCount +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", standard='" + standard + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", proportion='" + proportion + '\'' +
                '}';
    }
}
