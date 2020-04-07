package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.DiseaseAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 疾病分析
 */
@RestController
public class DiseaseAnalysisController {

    @Autowired
    DiseaseAnalysisService diseaseAnalysisService;

    /**
     * 疾病年龄段分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/ds/diseaseage")
    public String getDiseaseAge(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize){
        String restr = diseaseAnalysisService.getDiseaseAge(startTime,endTime,pageCount,pageSize);

        return restr;
    }

    /**
     * 疾病金额人次分析
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/ds/diseaseamount")
    public String getDiseaseAmount(@RequestParam(name ="startTime") String startTime, @RequestParam(name ="endTime")String endTime,
                                   @RequestParam(name = "pageCount") int pageCount,@RequestParam(name = "pageSize")int pageSize){
        String restr = diseaseAnalysisService.getDiseaseAmount(startTime,endTime,pageCount,pageSize);
        return restr;
    }

}
