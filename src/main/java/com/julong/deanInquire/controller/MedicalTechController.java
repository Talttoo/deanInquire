package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.MedicalTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医技信息
 */
@RestController
public class MedicalTechController {

    @Autowired
    MedicalTechService medicalTechService;


    /**
     *  医技明细工作量
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
   @GetMapping("/mt/detail")
    public String getMedicalDetailsWork(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                        @RequestParam(name="dept")int dept,@RequestParam(name="type")int type,
                                        @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize){
       String restr = medicalTechService.getMedicalDetailsWork(startTime, endTime,dept, type,pageCount,pageSize);
       return restr;
    }

    /**
     *  科室医技工作量
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/mt/deptwork")
    public String getDeptMedicalWork(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime
                                   ){
        String restr = medicalTechService.getDeptMedicalWork(startTime, endTime);
        return restr;
    }

}
