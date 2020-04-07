package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.dean.DeAllStaffBusinessDTO;
import com.julong.deanInquire.dto.entity.dean.DeClDailyDynamicsDTO;
import com.julong.deanInquire.dto.entity.dean.DeClWaitingQueueDTO;
import com.julong.deanInquire.provider.DeanDailyProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 1.院长日报
 */
@Mapper
public interface DeanDailyMapper {

    /**
    * 1）	当天全员业务动态
    * */
     @SelectProvider(method = "selectAllStaffBusinessPartner",type = DeanDailyProvider.class)
    public DeAllStaffBusinessDTO getAllStaffBusiness();

    /**
     * 2）	门诊人次每日动态
     */
    @SelectProvider(method = "selectClDailyDynamicsPartner",type = DeanDailyProvider.class)
    public List<DeClDailyDynamicsDTO> getClDailyDynamics(@Param("regDate")String regDate);


    /**
     *3）	门诊药房候药队列
     */
    @SelectProvider(method = "selectClWaitingQueuePartner",type = DeanDailyProvider.class)
    public List<DeClWaitingQueueDTO> getClWaitingQueue();


}
