package com.julong.deanInquire.dto.entity.item;
/**
 * //选择药品分类
*/
public class DrugClassificationDTO {

    private String  itemId ;
    private String itemCode ;
    private String  itemName;

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

    @Override
    public String toString() {
        return "DrugClassificationDTO{" +
                "itemId='" + itemId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
