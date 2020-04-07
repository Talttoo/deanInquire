package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.fs.FsHospitalIncomeDTO;
import com.julong.deanInquire.dto.entity.fs.FsPatientArrearsByPatientDTO;
import com.julong.deanInquire.dto.entity.fs.FsPatientArrearsDTO;
import com.julong.deanInquire.provider.FinancialStatusProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 财务状况
 */
@Mapper
public interface FinancialStatusMapper {

    /**
     * 全院收入分析
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectHospitalIncomePartner",type = FinancialStatusProvider.class)
    public List<FsHospitalIncomeDTO> getHospitalIncome(String startTime,String endTime,int dept,int type);

    /**
     *  出院病人欠款坏账分析-科室统计
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectPatientArrearsByDeptPartner",type = FinancialStatusProvider.class)
    public List<FsPatientArrearsDTO> getPatientArrearsByDept(String startTime,String endTime);

    /**
     *  出院病人欠款坏账分析-病人清单
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectPatientArrearsByPatientPartner",type = FinancialStatusProvider.class)
    public List<FsPatientArrearsByPatientDTO> getPatientArrearsByPatient(String startTime, String endTime);
}
