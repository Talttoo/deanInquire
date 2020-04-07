package com.julong.deanInquire.dto.entity.mt;
/**
 * 1）	医技明细工作量
*/
public class MtMedicalDetailsWorkDTO {
    private String itemId;
    private String itemCode;
    private String itemName;
    private double quantity;
    private double price;
    private double amount;
    private int type;//全院or门诊or住院  标识
   /* private String startingTime;//开始时间
    private String endTIme;//结束时间*/

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MtMedicalDetailsWorkDTO{" +
                "itemId='" + itemId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
