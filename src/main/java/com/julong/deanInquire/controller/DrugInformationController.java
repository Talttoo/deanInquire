package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.DrugInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * 药品信息
 */
@RestController
public class DrugInformationController {

    @Autowired
    DrugInformationService drugInformationService;

    /**
     * 医生药品金额排行榜
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/drug/drugamount")
    public String getDoctorsDrugAmount(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime){

        String restr=  drugInformationService.getDoctorsDrugAmount(startTime, endTime);


       // System.out.println(restr);
        return restr;
    }


    /**
     * 库存查询
     * @param locId
     * @param drugList
     * @return
     */
    @GetMapping("/drug/stock")
    public String getStockInquiry(@RequestParam(name = "locId") String locId, @RequestParam("drugList") List<String> drugList,
                                  @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize
                                  ){
        String restr= drugInformationService.getStockInquiry(locId, drugList, pageCount,  pageSize);



        return restr;
    }

    /**
     * 库房药品入库排行榜
     * @param startTime
     * @param endTime
     * @param deptId
     * @return
     */
    @GetMapping("/drug/treasury")
    public String getTreasuryDrugs(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                   @RequestParam(name = "deptId")String deptId,
                                   @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize
                                   ){

       // System.out.println("库房药品入库排行榜");
        String restr= drugInformationService.getTreasuryDrugs( startTime,  endTime,  deptId,pageCount,pageSize);
        //System.out.println(restr);
        return restr;
    }
    //selectMedicines  selectDrugConsumption

    /**
     * 抗生素和基本药物使用分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/drug/medicines")
    public String getDrlMedicines(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                  @RequestParam(name ="dept") int dept){
        String restr ="";
        if(dept==1){
             restr= drugInformationService.getDrlMedicinesForCl( startTime,  endTime);
        }else {
            restr= drugInformationService.getDrlMedicinesForIp( startTime,  endTime);
        }

       // System.out.println(restr);
        return restr;
    }

    /**
     * 药房药品消耗排行榜
     * @param startTime
     * @param endTime
     * @param locId
     * @return
     */
    @GetMapping("drug/consumption")
    public String getDrugConsumption(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                     @RequestParam(name = "deptId")String locId,
                                     @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize){

        String restr= drugInformationService.getDrugConsumption( startTime, endTime, locId,pageCount,pageSize);
        //System.out.println(restr);
        return restr;
    }
}
