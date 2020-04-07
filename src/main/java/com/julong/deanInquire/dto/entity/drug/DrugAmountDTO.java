package com.julong.deanInquire.dto.entity.drug;

/**
 * 计算药品消耗总合计用
 */
public class DrugAmountDTO {
    private String itemCode;
    private double amount;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DrugAmountDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", amount=" + amount +
                '}';
    }
}
