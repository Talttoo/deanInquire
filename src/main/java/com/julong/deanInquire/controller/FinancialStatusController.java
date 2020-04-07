package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.FinancialStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 财务分析
 */
@RestController
public class FinancialStatusController {
    @Autowired
    FinancialStatusService financialStatusService;

    /**
     *  全院收入分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/fs/income")
    public String getHospitalIncome(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                    @RequestParam(name ="dept") int dept, @RequestParam(name ="type")int type
                                    ){

       String restr = financialStatusService.getHospitalIncome(startTime,endTime,dept,type);

        return restr;
    }


    /**
     *  出院病人欠款坏账分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/fs/arrears")
   public String getPatientArrears(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime){

        String restr = financialStatusService.getPatientArrears(startTime,endTime);

        return restr;
   }
}
