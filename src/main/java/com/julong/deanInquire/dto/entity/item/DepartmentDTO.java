package com.julong.deanInquire.dto.entity.item;
/**
 * 选择科室
*/
public class DepartmentDTO {
    private String deptId;
    private String deptCode;
    private String deptName;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "deptId='" + deptId + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
