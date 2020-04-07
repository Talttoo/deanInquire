package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.drug.*;
import com.julong.deanInquire.dto.entity.item.DepartmentDTO;
import com.julong.deanInquire.provider.DrugInformationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 药品信息
 */
@Mapper
public interface DrugInformationMapper {

    /**
     * 医生药品金额排行榜
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectDoctorsDrugsPartner",type = DrugInformationProvider.class)
    public List<DrDoctorsDrugsDTO> getDoctorsDrugAmount(String startTime, String endTime);

    /**
     * 库存查询
     * @param locId
     * @param drugList
     * @return
     */
    @SelectProvider(method = "selectDrStockInquiryPartner",type = DrugInformationProvider.class)
    public List<DrStockInquiryDTO> getStockInquiry(String locId, List<String> drugList);

    /**
     * 库房药品入库排行榜
     * @param startTime
     * @param endTime
     * @param deptId
     * @return
     */
    @SelectProvider(method = "selectTreasuryDrugsPartner",type = DrugInformationProvider.class)
    public List<DrTreasuryDrugsDTO> getTreasuryDrugs(String startTime, String endTime, String deptId);

    /**
     * 库房药品入库排行榜-总合计
     * @param startTime
     * @param endTime
     * @param deptId
     * @return
     */
    @SelectProvider(method = "selectTreasuryDrugsTotalAmountPartner",type = DrugInformationProvider.class)
    public List<DrTreasuryDrugsDTO> getTreasuryDrugsTotalAMount(String startTime,String endTime,String deptId);



    /**
     * 抗生素和基本药品使用分析-门诊科室
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectMedicinesClDept",type = DrugInformationProvider.class)
    public List<DepartmentDTO> getMedicinesClDept(String startTime, String endTime);

    /**
     * 抗生素和基本药品使用分析-住院科室
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectMedicinesIpDept",type = DrugInformationProvider.class)
    public List<DepartmentDTO> getMedicinesIpDept(String startTime, String endTime);

    /**
     * 抗生素和基本药品使用分析-门诊分析
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectClMedicines",type = DrugInformationProvider.class)
    public List<DrlMedicinesDTO> getDrlMedicinesForCl(String startTime, String endTime, String deptId);


    /**
     * 抗生素和基本药品使用分析-门诊分析-科室为空
     * @param startTime
     * @param endTime
     * @return
     */
    public List<DrlMedicinesDTO> getDrlMedicinesForClNull(String startTime,String endTime);

    /**
     * 抗生素和基本药品使用分析-住院分析
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectIpMedicines",type = DrugInformationProvider.class)
    public List<DrlMedicinesDTO> getDrlMedicinesForIp(String startTime,String endTime,String deptId);

    /**
     * 药房药品消耗排行榜
     * @param startTime
     * @param endTime
     * @param locId
     * @return
     */
    @SelectProvider(method = "selectDrugConsumption",type = DrugInformationProvider.class)
    public List<DrDrugConsumptionDTO> getDrugConsumption(String startTime, String endTime, String locId);

    /**
     * 药房药品消耗排行榜-总合计
     * @param startTime
     * @param endTime
     * @param locId
     * @return
     */
    @SelectProvider(method = "selectDrugConsumptionForSum",type = DrugInformationProvider.class)
    public  List<DrugAmountDTO> getDrugConsumptionTotalPage(String startTime,String endTime,String locId);




}
