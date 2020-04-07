package com.julong.deanInquire.dto.entity.dean;

/**
 * //3）	门诊药房候药队列
 */
public class DeClWaitingQueueDTO {

    private String queueId;//
    private String recipeId;//
    private String name;//
    private String winCode;//
    private String winName;//
    private int rowNo;//

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinCode() {
        return winCode;
    }

    public void setWinCode(String winCode) {
        this.winCode = winCode;
    }

    public String getWinName() {
        return winName;
    }

    public void setWinName(String winName) {
        this.winName = winName;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    @Override
    public String toString() {
        return "DeClWaitingQueueDTO{" +
                "queueId='" + queueId + '\'' +
                ", recipeId='" + recipeId + '\'' +
                ", name='" + name + '\'' +
                ", winCode='" + winCode + '\'' +
                ", winName='" + winName + '\'' +
                ", rowNo=" + rowNo +
                '}';
    }
}
