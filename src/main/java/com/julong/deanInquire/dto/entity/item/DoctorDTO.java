package com.julong.deanInquire.dto.entity.item;
/*
* //选择医生
* */
public class DoctorDTO {

    private String userId;
    private String userCode;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "userId='" + userId + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
