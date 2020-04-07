package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoParameterModel;
import com.julong.deanInquire.dto.entity.fs.FsHospitalIncomeDTO;
import com.julong.deanInquire.dto.entity.fs.FsPatientArrearsByPatientDTO;
import com.julong.deanInquire.dto.entity.fs.FsPatientArrearsDTO;
import com.julong.deanInquire.mapper.FinancialStatusMapper;
import com.julong.deanInquire.utils.data.FinancialStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 财务状况
 */
@Service
public class FinancialStatusService {
    @Autowired
    FinancialStatusMapper financialStatusMapper;

    /**
     *  全院收入分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String getHospitalIncome(String startTime, String  endTime,int dept, int type ){

        FinancialStatusUtil financialStatusUtil = new FinancialStatusUtil();
        List<FsHospitalIncomeDTO> fsHospitalIncomeDTOS = financialStatusMapper.getHospitalIncome( startTime,  endTime,dept,type);

        String str1= financialStatusUtil.getHospitalIncome(fsHospitalIncomeDTOS);

        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
       // JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject = JSONObject.parseObject(str1);
        // 传入模型.
        returnParameterModel.setData(jsonObject);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
        System.out.println(restr);

        return restr;
    }

    /**
     * 出院病人欠款坏账分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String getPatientArrears(String startTime, String  endTime){

        FinancialStatusUtil financialStatusUtil = new FinancialStatusUtil();
        //查询科室统计数据
        List<FsPatientArrearsDTO> fsPatientArrearsDTOS = financialStatusMapper.getPatientArrearsByDept( startTime,  endTime);
        //查询病人清单数据
        List<FsPatientArrearsByPatientDTO> fsPatientArrearsByPatientDTOS = financialStatusMapper.getPatientArrearsByPatient(startTime,  endTime);

        //组装科室统计数据
        String str1 = financialStatusUtil.getPatientArrears(fsPatientArrearsDTOS);
        //组装病人清单数据
        String str2 = financialStatusUtil.getPatientArrearsByPatient(fsPatientArrearsByPatientDTOS);

        // 创建实例
        ReturnTwoParameterModel returnTwoParameterModel = new ReturnTwoParameterModel();

        // 返回code
        returnTwoParameterModel.setStatusCode(200);

        // 转为JSONArray
        //JSONArray jsonArray= JSONArray.parseArray(str2);
        JSONObject jsonObject = JSONObject.parseObject(str1);
        JSONObject jsonObject2 = JSONObject.parseObject(str2);
        // 传入模型.
        returnTwoParameterModel.setData(jsonObject);
        returnTwoParameterModel.setData_2(jsonObject2);

        // 返回errMsg
        returnTwoParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnTwoParameterModel);
        //System.out.println(restr);

        return restr;
    }
}
