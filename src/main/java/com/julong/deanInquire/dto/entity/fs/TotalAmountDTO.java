package com.julong.deanInquire.dto.entity.fs;

public class TotalAmountDTO {
    private double totalAmount;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "TotalAmountDTO{" +
                "totalAmount=" + totalAmount +
                '}';
    }
}
