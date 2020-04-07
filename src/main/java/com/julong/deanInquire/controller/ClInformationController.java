package com.julong.deanInquire.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.entity.cl.ClBigPrescriptionQueryDTO;
import com.julong.deanInquire.dto.entity.cl.ClBusinessConditionDTO;
import com.julong.deanInquire.service.ClInformationService;
import com.julong.deanInquire.utils.data.ClInformationUtil;
import com.julong.deanInquire.utils.other.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 门诊信息
 */
@RestController
public class ClInformationController {

    private static final Logger log = LoggerFactory.getLogger(ClInformationController.class);

    @Autowired
    ClInformationService clInformationService;
    @Autowired
    ClInformationUtil clInformationUtil;

    /**
     *  门诊业务状况分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/cl/Business")
    public String getBusinessCondition(@RequestParam(name = "startTime")String startTime, @RequestParam(name = "endTime")String endTime){

        String restr = "";
        //
        try {
            restr = clInformationService.getBusinessCondition(startTime, endTime);
        }catch (Exception e){
            e.printStackTrace();
            log.error(""+e);
        }



        return restr;
    }

    /**
     *  门诊大处方查询
     * @param startTime
     * @param endTime
     * @param cataAmount
     * @param deptId
     * @param cataId
     * @param doctorId
     * @param pageCount
     * @param pageSize
     * @return
     */
    @GetMapping("/cl/bigprescription")
    public String getBigPrescription(@RequestParam(name = "startTime")String startTime, @RequestParam(name = "endTime")String endTime,
                                     @RequestParam(name = "cataAmount")int cataAmount, @RequestParam(name = "deptId")String deptId,
                                     @RequestParam(name = "cataId")String cataId,@RequestParam(name = "doctorId")String doctorId,
                                     @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize){

        //System.out.println("cataAmount:"+cataAmount+"   deptId: "+deptId+"   cataId:"+cataId+"   doctorId:"+doctorId);
        String restr = "";
        try {
            restr  = clInformationService.getBigPrescription(startTime, endTime, cataAmount, deptId, cataId, doctorId,pageCount,pageSize);
        }catch (Exception e){
            e.printStackTrace();
            log.error(""+e);
        }

        return restr;

    }

    /**
     *  门诊药品消耗趋势分析
     * @param startTime
     * @param endTime
     * @param itemId
     * @return
     */
    @GetMapping("/cl/drugconsumption")
    public String getDrugConsumption(@RequestParam(name = "startTime")String startTime, @RequestParam(name = "endTime")String endTime,
                                     @RequestParam(name = "itemId")String itemId){
        // 返回前端
        String restr = clInformationService.getDrugConsumption(startTime, endTime, itemId);

        //System.out.println(restr);

        return restr;

    }

    /**
     *  门诊药品统计
     * @param startTime
     * @param endTime
     * @param statisticType
     * @param order
     * @return
     */
    @GetMapping("/cl/drugstatistics")
    public String getDrugStatistics(@RequestParam(name = "startTime")String startTime, @RequestParam(name = "endTime")String endTime,
                                    @RequestParam(name = "statisticType")int statisticType,@RequestParam(name = "order")String  order,
                                    @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize){
        // 返回前端
        String restr = clInformationService.getDrugStatistics(startTime, endTime, statisticType, order, pageCount, pageSize);

        //System.out.println(restr);

        return restr;
    }

    /**
     *  门诊量分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/cl/volumeAnalysis")
    public String getVolumeAnalysis(@RequestParam(name = "startTime")String startTime, @RequestParam(name = "endTime")String endTime){

       // System.out.println("请求数据的时间段："+ startTime+" ----"+endTime);

        String restr = clInformationService.getVolumeAnalysis(startTime,endTime);

        return restr;


    }









}
