package com.julong.deanInquire.controller;

import com.julong.deanInquire.service.MedicalNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医疗动态
 */
@RestController
public class MedicalNewsController {

    @Autowired
    MedicalNewsService medicalNewsService;

    /**
     * 在院病人分布情况
     * @return
     */
    @GetMapping("/mn/patient")
    public String getPatientsDistribution(){

        String restr = medicalNewsService.getPatientsDistribution();

        return restr;
    }
}
