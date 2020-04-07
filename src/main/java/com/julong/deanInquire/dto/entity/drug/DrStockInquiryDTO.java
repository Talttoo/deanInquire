package com.julong.deanInquire.dto.entity.drug;
/**
*   2）	库存查询
*/
public class DrStockInquiryDTO {
    private String stuffCode;
    private String stuffName;
    private String standard;
    private String unitName;
    private int quantity;
    private double buyAmount;
    private double saleAmount;

    public String getStuffCode() {
        return stuffCode;
    }

    public void setStuffCode(String stuffCode) {
        this.stuffCode = stuffCode;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
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

    public double getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(double buyAmount) {
        this.buyAmount = buyAmount;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    @Override
    public String toString() {
        return "DrStockInquiryDTO{" +
                "stuffCode='" + stuffCode + '\'' +
                ", stuffName='" + stuffName + '\'' +
                ", standard='" + standard + '\'' +
                ", unitName='" + unitName + '\'' +
                ", quantity=" + quantity +
                ", buyAmount=" + buyAmount +
                ", saleAmount=" + saleAmount +
                '}';
    }
}
