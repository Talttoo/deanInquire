package com.julong.deanInquire.dto.entity.cl;
/**
*  //4）	门诊药品统计
 */
public class ClDrugStatisticsDTO {
    private int rowNum;
    private String itemCode;
    private String itemName;
    private String standard;
    private String unitName;
    private String quantity;
    private double amount;
   /* private String startingTime;//开始时间
    private String endTIme;//结束时间*/

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
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
        return "ClDrugStatisticsDTO{" +
                "rowNum=" + rowNum +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", standard='" + standard + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", amount=" + amount +
                '}';
    }
}
