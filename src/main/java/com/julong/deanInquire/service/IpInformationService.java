package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoParameterModel;
import com.julong.deanInquire.dto.entity.ip.IpDrugRevenueRatioDTO;
import com.julong.deanInquire.dto.entity.ip.IpSettlementIncomeByDeptDTO;
import com.julong.deanInquire.dto.entity.ip.IpSettlementIncomeDTO;
import com.julong.deanInquire.mapper.IpInformationMapper;
import com.julong.deanInquire.utils.data.IpInformationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 住院信息
 */
@Service
public class IpInformationService {
    @Autowired
    IpInformationMapper informationMapper;


    /**
     * 住院结算收入分析图
     * @param selectTime
     * @return
     */
    public String getSettlementIncome(String selectTime){


        IpInformationUtil ipInformationUtil = new IpInformationUtil();

        List<IpSettlementIncomeDTO> ipSettlementIncomeDTOS = informationMapper.getSettlementIncomeByDate(selectTime);

        List<IpSettlementIncomeByDeptDTO> ipSettlementIncomeByDeptDTOS = informationMapper.getSettlementIncomeByDept(selectTime);

        String str1 = ipInformationUtil.getSettlementIncomeByDate(ipSettlementIncomeDTOS);
        String str2 = ipInformationUtil.getSettlementIncomeByDept(ipSettlementIncomeByDeptDTOS);

        ReturnTwoParameterModel returnTwoParameterModel= new ReturnTwoParameterModel();


        JSONObject jsonObject1 = JSONObject.parseObject(str1);
        JSONObject jsonObject2= JSONObject.parseObject(str2);

        returnTwoParameterModel.setStatusCode(200);
        returnTwoParameterModel.setData(jsonObject1);
        returnTwoParameterModel.setData_2(jsonObject2);
        returnTwoParameterModel.setErrMsg("success");

        String restr= JSON.toJSONString(returnTwoParameterModel);

        return restr;

    }

    /**
     * 住院药品收入分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String getIpDrugRevenueRatio(String startTime,String endTime){

      List<IpDrugRevenueRatioDTO> ipDrugRevenueRatioDTOS =  informationMapper.getIpDrugRevenueRatioDTO(startTime,endTime);

      //封装表格所需数据
      IpInformationUtil ipInformationUtil = new IpInformationUtil();

      String str1= ipInformationUtil.getIpDrugRevenueRatio(ipDrugRevenueRatioDTOS);

        //封装图表所需要的数据
        String str2 = ipInformationUtil.getIpDrugRevenueRatioForChart(ipDrugRevenueRatioDTOS);


        // 创建实例
        ReturnTwoParameterModel returnParameterModel = new ReturnTwoParameterModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        //JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject1 = JSONObject.parseObject(str1);
        JSONObject jsonObject2 = JSONObject.parseObject(str2);
        // 传入模型.
        returnParameterModel.setData(jsonObject1);
        returnParameterModel.setData_2(jsonObject2);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);

        return restr;


    }


}
