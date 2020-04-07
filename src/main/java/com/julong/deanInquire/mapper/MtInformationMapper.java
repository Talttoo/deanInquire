package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.mt.MtDeptMedicalWorkDTO;
import com.julong.deanInquire.dto.entity.mt.MtMedicalDetailsWorkDTO;
import com.julong.deanInquire.provider.MtInformationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 医技信息
 */
@Mapper
public interface MtInformationMapper {


    /**
     * 科室医技工作量
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectDeptMedicalWorkPartner",type = MtInformationProvider.class)
    public List<MtDeptMedicalWorkDTO> getDeptMedicalWork(String startTime,String endTime);

    /**
     * 科室医技工作量-门诊(不用)
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectClMedicalWorkPartner",type = MtInformationProvider.class)
    public List<MtDeptMedicalWorkDTO> getClMedicalWork(String startTime,String endTime);

    /**
     * 科室医技工作量-住院（不用）
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(method = "selectIpMedicalWorkPartner",type = MtInformationProvider.class)
    public List<MtDeptMedicalWorkDTO> getIpMedicalWork(String startTime,String endTime);

    /**
     * 医技明细工作量
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
    @SelectProvider(method = "selectMedicalDetailsWorkPartner",type = MtInformationProvider.class)
    public List<MtMedicalDetailsWorkDTO> getMedicalDetailsWork(String startTime,String endTime,int dept,int type);

}
