package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.ds.DsDiseaseAgeDTO;
import com.julong.deanInquire.dto.entity.ds.DsDiseaseAmountDTO;
import com.julong.deanInquire.provider.DsDiseaseAnalysisProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface DiseaseAnalysisMapper {
    @SelectProvider(method = "selectDiseaseAgePartner",type = DsDiseaseAnalysisProvider.class)
    public List<DsDiseaseAgeDTO> getDiseaseAge(String startTime,String endTime);

    @SelectProvider(method = "selectDiseaseAmountProvider",type = DsDiseaseAnalysisProvider.class)
    public List<DsDiseaseAmountDTO> getDiseaseAmount(String startTime,String endTime);

}
