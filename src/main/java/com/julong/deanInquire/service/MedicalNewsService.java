package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.entity.mn.MnPatientsDistributionDTO;
import com.julong.deanInquire.mapper.MnPatientsDistributionMapper;
import com.julong.deanInquire.utils.data.MedicalNewsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 医疗动态
 */
@Service
public class MedicalNewsService {
    @Autowired
    MnPatientsDistributionMapper mnPatientsDistributionMapper;

    /**
     * 在院病人分布情况
     * @return
     */
    public String getPatientsDistribution(){

        MedicalNewsUtil medicalNewsUtil = new MedicalNewsUtil();

        List<MnPatientsDistributionDTO> mnPatientsDistributionDTOS = mnPatientsDistributionMapper.getPatientsDistribution();

        String str1= medicalNewsUtil.getPatientsDistributionForChart(mnPatientsDistributionDTOS);

        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        //JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject = JSONObject.parseObject(str1);
        // 传入模型.
        returnParameterModel.setData(jsonObject);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);

        return restr;
    }
}
