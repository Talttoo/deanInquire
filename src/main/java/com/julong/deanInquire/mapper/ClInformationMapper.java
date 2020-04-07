package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.cl.*;
import com.julong.deanInquire.dto.inpram.cl.BigPrescriptionQueryPramBean;
import com.julong.deanInquire.dto.inpram.cl.DrugConsumptionPramBean;
import com.julong.deanInquire.dto.inpram.cl.DrugStatisticsPramBean;
import com.julong.deanInquire.provider.CInformationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 2.	门诊信息
 */
@Mapper
public interface ClInformationMapper {
    /**
     * 1）	门诊业务状况分析
     * @return
     */
    @SelectProvider(method = "selectBusinessConditionPartner", type = CInformationProvider.class)
    public List<ClBusinessConditionDTO> getBusinessCondition(String starTime, String endTime);

    /**
     * 2）	门诊大处方查询
     * @param bigPrescriptionQueryPramDTO
     * @return
     */
    @SelectProvider(method = "selectBigPrescriptionPartner",type = CInformationProvider.class)
    public List<ClBigPrescriptionQueryDTO> getBigPrescriptionByPram(BigPrescriptionQueryPramBean bigPrescriptionQueryPramDTO);


    /**
     * 药品消耗趋势排行榜
     * @param drugConsumptionPramDTO
     * @return
     */
    @SelectProvider(method = "selectDrugConsumptionPartner",type = CInformationProvider.class)
    public List<ClDrugConsumptionDTO> getDrugConsumptionDTO(DrugConsumptionPramBean drugConsumptionPramDTO);

    /**
     * 门诊药品统计
     * @param drugStatisticsPramBean
     * @return
     */
    @SelectProvider(method = "selectDrugStatisticsPartner",type = CInformationProvider.class)
    public List<ClDrugStatisticsDTO> getDrugStatistics(DrugStatisticsPramBean drugStatisticsPramBean);

    /**
     *  门诊量分析-科室分析
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectVolumeAnalysisPartner",type = CInformationProvider.class)
    public List<ClVolumeAnalysisDTO> getVolumeAnalysis(String startTime, String endTime);

    /**
     *  门诊量分析-性别分析
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectGenderAnalysisPartner",type = CInformationProvider.class)
    public List<ClGenderAnalysisDTO> getGenderAnalysis(String startTime,String endTime);

    /**
     *  门诊量分析-日期分析
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectDateAnalysisPartner",type = CInformationProvider.class)
    public List<ClDateAnalysisDTO> getDateAnalysis(String startTime,String endTime);





}
