package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.DeanDdailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 院长日报
 */
@RestController
public class DeanDdailyController {

    @Autowired
    DeanDdailyService deanDdailyService;


    /**
     * 当天全员业务
     * @return
     */
    @GetMapping("/dean/business")
    public  String getAllStaffBusiness(){

      String restr = deanDdailyService.getAllStaffBusiness();

      return restr;

    }

    /**
     * 门诊每日动态
     * @return
     */
    @GetMapping("/dean/cldaily")
    public String getClDailyDynamic(@RequestParam(name="regDate")String regDate){
        String restr = deanDdailyService.getClDailyDynamic(regDate);
        return restr;
    }

    /**
     * 门诊等候队列
     * @return
     */
    @GetMapping("/dean/waitqueue")
    public String getClWaitingQueue(){
        String restr = deanDdailyService.getClWaitingQueue();
        return restr;

    }







}
