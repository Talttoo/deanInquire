package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.ip.IpDrugRevenueRatioDTO;
import com.julong.deanInquire.dto.entity.ip.IpSettlementIncomeByDeptDTO;
import com.julong.deanInquire.dto.entity.ip.IpSettlementIncomeDTO;
import com.julong.deanInquire.provider.IpInformationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface IpInformationMapper {

    @SelectProvider(method = "selectSettlementIncomePartnerbyDate",type = IpInformationProvider.class)
    public List<IpSettlementIncomeDTO> getSettlementIncomeByDate(String selectTime);

    @SelectProvider(method = "selectSettlementIncomePartnerbyDept",type = IpInformationProvider.class)
    public List<IpSettlementIncomeByDeptDTO> getSettlementIncomeByDept(String selectTime);

    @SelectProvider(method = "selectDrugRevenueRatio",type = IpInformationProvider.class)
    public List<IpDrugRevenueRatioDTO> getIpDrugRevenueRatioDTO(String startTime, String endTime);

}
