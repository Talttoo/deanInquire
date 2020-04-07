package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.IpInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 住院信息
 */
@RestController
public class IpInformationController {
    @Autowired
    IpInformationService ipInformationService;


    /**
     *  住院结算收入分析图
     * @param selectTime
     * @return
     */
    @GetMapping("/ip/income")
    public String  getSettlementIncome(@RequestParam(name ="selectTime")String selectTime ){

        String restr= ipInformationService.getSettlementIncome(selectTime);

        return restr;
    }

    /**
     *  住院药品收入比例
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/ip/drug")
  public String getIpDrugRevenueRatio(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime){

        String restr = ipInformationService.getIpDrugRevenueRatio(startTime, endTime);

        return restr;

  }

}
