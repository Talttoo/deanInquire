package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.julong.deanInquire.dto.entity.cl.ClDrugConsumptionDTO;
import com.julong.deanInquire.dto.utils.ReturnDrugListDTO;

import java.util.ArrayList;
import java.util.List;

public class DrugConsumptionService {

    public String getQuanlityAndAmount(List<ClDrugConsumptionDTO> list){
        ReturnDrugListDTO returnDrugListDTO = new ReturnDrugListDTO();

        List<Double> amountList = new ArrayList<>();
        List<Integer> quanlityList = new ArrayList<>();
        List<String> timeList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            amountList.add(list.get(i).getAmount());
            quanlityList.add(list.get(i).getQuantity());
            timeList.add(list.get(i).getChargeTime());
        }
        String str1= JSON.toJSONString(amountList);
        String str2= JSON.toJSONString(quanlityList);
        String str3= JSON.toJSONString(timeList);
        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONArray jsonArray_2= JSONArray.parseArray(str2);
        JSONArray jsonArray_3= JSONArray.parseArray(str3);
        // 传入模型.
        returnDrugListDTO.setData_1(jsonArray);
        returnDrugListDTO.setData_2(jsonArray_2);
        returnDrugListDTO.setData_3(jsonArray_3);

        // 返回controller
        String restr = JSON.toJSONString(returnDrugListDTO);

       // System.out.println(restr);

        return restr;


    }
}
