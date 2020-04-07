package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.julong.deanInquire.dto.entity.drug.*;
import com.julong.deanInquire.dto.entity.item.DepartmentDTO;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoParameterModel;
import com.julong.deanInquire.dto.ReturnModel.page.ReturnDataByPageModel;
import com.julong.deanInquire.dto.ReturnModel.page.ReturnThreeDataByPageModel;
import com.julong.deanInquire.mapper.DrugInformationMapper;
import com.julong.deanInquire.utils.data.DrugInformationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 药品信息
 */
@Service
public class DrugInformationService {
    @Autowired
    DrugInformationMapper drugInformationMapper;

    //保留两位小数
    DecimalFormat df = new DecimalFormat("#.00");
    //百分数保留两位小数
    DecimalFormat df_percent = new DecimalFormat("0.00%");
    DrugInformationUtil drugInformationUtil = new DrugInformationUtil();

    double drugConsumtion_totalAmount = 0;
    double treasuryDrugs_totalAmount = 0;


    /**
     *  医生药品金额排行榜
     * @param startTime
     * @param endTime
     * @return
     */
    public String getDoctorsDrugAmount( String startTime, String endTime){


        List<DrDoctorsDrugsDTO> drDoctorsDrugsDTOS = drugInformationMapper.getDoctorsDrugAmount(startTime, endTime);
        DrugInformationUtil drugInformationUtil = new DrugInformationUtil();
        //计算门诊，住院和全院总金额
        DrugsFeeDataDTO drugsFeeDataDTO = drugInformationUtil.getDrugsFeeData(drDoctorsDrugsDTOS);

        String str1= JSON.toJSONString(drDoctorsDrugsDTOS);
        String str2 = JSON.toJSONString(drugsFeeDataDTO);
        // 创建实例
        ReturnTwoParameterModel returnParameterModel = new ReturnTwoParameterModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject = JSONObject.parseObject(str2);
        // 传入模型.
        returnParameterModel.setData(jsonArray);
        returnParameterModel.setData_2(jsonObject);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
        //System.out.println(restr);

        return restr;
    }


    /**
     *  库存查询
     * @param locId
     * @param drugList
     * @return
     */
    public String getStockInquiry(String locId, List<String> drugList,int pageCount, int pageSize){


        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<DrStockInquiryDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<DrStockInquiryDTO> drStockInquiryDTOS = drugInformationMapper.getStockInquiry(locId, drugList);
        //System.out.println("总条数"+page.getTotal());
       // System.out.println("总页数"+page.getPages());
        String str1= JSON.toJSONString(drStockInquiryDTOS);
        // 根据分页  创建实例
        ReturnDataByPageModel returnDataByPageModel = new ReturnDataByPageModel();

        // 返回code
        returnDataByPageModel.setStatusCode(200);
        returnDataByPageModel.setTotalPage(page.getPages());

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        //JSONObject jsonObject = JSONObject.parseObject(str1);
        // 传入模型.
        returnDataByPageModel.setData(jsonArray);

        // 返回errMsg
        returnDataByPageModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnDataByPageModel);
        //System.out.println(restr);

        return restr;
    }


    /**
     *  库房药品入库排行榜
     * @param startTime
     * @param endTime
     * @param deptId
     * @return
     */
    public String getTreasuryDrugs(String startTime, String endTime,String deptId,int pageCount, int pageSize){
        int rowcount=0;
        List<NewDrTreasuryDrugsDTO> newDrTreasuryDrugsDTOS = new ArrayList<>();
        List<DrTreasuryDrugsDTO> drTreasuryDrugsDTOS = new ArrayList<>();
        NewDrTreasuryDrugsDTO sumDTO = new NewDrTreasuryDrugsDTO();
       // DrugInformationUtil drugInformationUtil = new DrugInformationUtil();
        //分页获取数据
        Page<DrTreasuryDrugsDTO> page = PageHelper.startPage(pageCount, pageSize);
        drTreasuryDrugsDTOS = drugInformationMapper.getTreasuryDrugs(startTime, endTime, deptId);

        //根据页数，计算行号
        if(pageCount>1){
            rowcount = (pageCount-1)*pageSize;
        }

        // System.out.println("第几条："+rowcount);
        //给图表准备数据
        String str1 = "";
        //第一页就计算图表数据，第二页之后不再重复计算
        if(pageCount==1) {
            str1 = drugInformationUtil.getTreasuryDrugsForChart(drTreasuryDrugsDTOS);
        }

        //如果是最后一页，计算总合计
        if(pageCount==page.getPages()){

            List<DrTreasuryDrugsDTO> list  = drugInformationMapper.getTreasuryDrugsTotalAMount( startTime,  endTime,  deptId);

            sumDTO = drugInformationUtil.getTreasuryDrugsTotaAmount(list);


        }else {//不是最后一页，返回-1
            sumDTO.setItemName("总合计");
            sumDTO.setAmount(-1);
        }

        //遍历，计算行号
        for(int i=0;i<drTreasuryDrugsDTOS.size();i++){
            NewDrTreasuryDrugsDTO newDrTreasuryDrugsDTO = new NewDrTreasuryDrugsDTO();
            newDrTreasuryDrugsDTO.setRowCount(rowcount+i+1);
            newDrTreasuryDrugsDTO.setItemCode(drTreasuryDrugsDTOS.get(i).getItemCode());
            newDrTreasuryDrugsDTO.setItemName(drTreasuryDrugsDTOS.get(i).getItemName());
            newDrTreasuryDrugsDTO.setAmount(drTreasuryDrugsDTOS.get(i).getAmount());
            newDrTreasuryDrugsDTO.setQuantity(drTreasuryDrugsDTOS.get(i).getQuantity());
            newDrTreasuryDrugsDTO.setUnitName(drTreasuryDrugsDTOS.get(i).getUnitName());
            newDrTreasuryDrugsDTOS.add(newDrTreasuryDrugsDTO);
        }





        String str2= JSON.toJSONString(newDrTreasuryDrugsDTOS);
        String str3= JSON.toJSONString(sumDTO);
        // 创建实例
        ReturnThreeDataByPageModel returnThreeDataByPageModel = new ReturnThreeDataByPageModel();

        // 返回code
        returnThreeDataByPageModel.setStatusCode(200);
        returnThreeDataByPageModel.setTotalPage(page.getPages());

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str2);
        JSONObject jsonObject = JSONObject.parseObject(str1);
        JSONObject jsonObject1 = JSONObject.parseObject(str3);

        // 传入模型.
        returnThreeDataByPageModel.setData(jsonArray);
        returnThreeDataByPageModel.setData_2(jsonObject);
        returnThreeDataByPageModel.setData_3(jsonObject1);
        // 返回errMsg
        returnThreeDataByPageModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnThreeDataByPageModel);

        //System.out.println(restr);

        return restr;
    }
    //selectMedicines  selectDrugConsumption

    /**
     *  抗生素和基本药品使用分析-门诊
     * @param startTime
     * @param endTime
     * @return
     */
    public String getDrlMedicinesForCl(String startTime,String endTime){

        String deptId = "";
        double sumAntFee=0,sumGenFee=0, sumTotal=0; //最终合计
        String sumAntFeeInTotal="0.0%";
        String sumGenFeeInTotal="0.0%";
        List<DepartmentDTO> deptList = drugInformationMapper.getMedicinesClDept(startTime,  endTime);
        //System.out.println(deptList.toString());
        //将各个科室的list集合合并到一个list
       List<List<NewDrlMedicinesDTO>> totalList = new ArrayList<>();
       //保留两位有效小数
        DecimalFormat df = new DecimalFormat("#.00");
        //遍历科室list，根据科室id 和时间查询数据
        for(int i=0;i<deptList.size();i++){
            List<DrlMedicinesDTO> cllMedicinesList = new ArrayList<>();
//            deptId = deptList.get(i).getDeptId();
//            cllMedicinesList  = drugInformationMapper.getDrlMedicinesForCl( startTime,  endTime,deptId);

            //科室不为空，根据科室id查找数据
            if(deptList.get(i)!=null){
                deptId = deptList.get(i).getDeptId();
                cllMedicinesList  = drugInformationMapper.getDrlMedicinesForCl( startTime,  endTime,deptId);
            }else{
                //科室为空
                cllMedicinesList  = drugInformationMapper.getDrlMedicinesForCl( startTime,  endTime,null);
               // cllMedicinesList  = drugInformationMapper.getDrlMedicinesForClNull( startTime,  endTime,null);
            }

           // System.out.println("cllMedicinesList:"+cllMedicinesList.toString());
            List <NewDrlMedicinesDTO>  newDrlMedicinesList = new ArrayList<>();
            double antibacterialFee=0,genericFee=0, total=0;
            String antibacterialFeeInTotal="0.0%";
            String genericFeeInTotal="0.0%";

            //遍历list，计算抗生素和普遍药品比例
            for (int j=0;j<cllMedicinesList.size();j++){

                    NewDrlMedicinesDTO newDrlMedicinesDTO = new NewDrlMedicinesDTO();
                    newDrlMedicinesDTO.setDeptCode(cllMedicinesList.get(j).getDeptCode());
                    newDrlMedicinesDTO.setDeptName(cllMedicinesList.get(j).getDeptName());
                    newDrlMedicinesDTO.setDoctorCode(cllMedicinesList.get(j).getDoctorCode());
                    newDrlMedicinesDTO.setDoctorName(cllMedicinesList.get(j).getDoctorName());
                    newDrlMedicinesDTO.setAntibacterialFee(cllMedicinesList.get(j).getAntibacterialFee());
                    newDrlMedicinesDTO.setGenericFee(cllMedicinesList.get(j).getGenericFee());
                    newDrlMedicinesDTO.setTotal(cllMedicinesList.get(j).getTotal());
                    String antFeeInTotal = "0.0%";
                    String genFeeInTotal = "0.0%";

                    if (cllMedicinesList.get(j).getTotal() != 0&&cllMedicinesList.get(j).getAntibacterialFee()!=0) {
                        antFeeInTotal = df_percent.format(cllMedicinesList.get(j).getAntibacterialFee() / cllMedicinesList.get(j).getTotal());

                        newDrlMedicinesDTO.setAntibacterialFeeInTotal(antFeeInTotal);

                    } else{
                        newDrlMedicinesDTO.setAntibacterialFeeInTotal("0.0%");
                    }

                    if (cllMedicinesList.get(j).getTotal() != 0&&cllMedicinesList.get(j).getGenericFee()!=0){
                        genFeeInTotal = df_percent.format(cllMedicinesList.get(j).getGenericFee() / cllMedicinesList.get(j).getTotal());
                        newDrlMedicinesDTO.setGenericFeeInTotal(genFeeInTotal);
                    } else {

                        newDrlMedicinesDTO.setGenericFeeInTotal("0.0%");
                    }
                antibacterialFee+=cllMedicinesList.get(j).getAntibacterialFee();
                genericFee+=cllMedicinesList.get(j).getGenericFee();
                total+=cllMedicinesList.get(j).getTotal();

                newDrlMedicinesList.add(newDrlMedicinesDTO);
            }
            //遍历完成之后，计算科室小计，加到list最后
            NewDrlMedicinesDTO sumDrlMedicinesDTO = new NewDrlMedicinesDTO();
            sumDrlMedicinesDTO.setDoctorName("科室小计");
            sumDrlMedicinesDTO.setAntibacterialFee(Double.parseDouble(df.format(antibacterialFee)));
            sumDrlMedicinesDTO.setGenericFee(Double.parseDouble(df.format(genericFee)));
            sumDrlMedicinesDTO.setTotal(Double.parseDouble(df.format(total)));
            if(total!=0&&antibacterialFee!=0){
                antibacterialFeeInTotal= df_percent.format(antibacterialFee/total);
                sumDrlMedicinesDTO.setAntibacterialFeeInTotal(antibacterialFeeInTotal);

            }else{
                sumDrlMedicinesDTO.setAntibacterialFeeInTotal("0.0%");
            } if(total!=0&&genericFee!=0){
                genericFeeInTotal= df_percent.format(genericFee/total);
                sumDrlMedicinesDTO.setGenericFeeInTotal(genericFeeInTotal);
            }else {

                sumDrlMedicinesDTO.setGenericFeeInTotal("0.0%");
            }
            newDrlMedicinesList.add(sumDrlMedicinesDTO);

            //计算最终合计数据
            sumAntFee+=Double.parseDouble(df.format(antibacterialFee));
            sumGenFee+=Double.parseDouble(df.format(genericFee));
            sumTotal+=Double.parseDouble(df.format(total));

            //将各个科室的list集合合并到一个list
            totalList.add(newDrlMedicinesList);
        }
        NewDrlMedicinesDTO sumDTO = new NewDrlMedicinesDTO();
        sumDTO.setAntibacterialFee(Double.parseDouble(df.format(sumAntFee)));
        sumDTO.setGenericFee(Double.parseDouble(df.format(sumGenFee)));
        sumDTO.setTotal(Double.parseDouble(df.format(sumTotal)));
        if(sumTotal>0&&sumAntFee>0){

            sumDTO.setAntibacterialFeeInTotal(df_percent.format(sumAntFee/sumGenFee));

        }else{
            sumDTO.setAntibacterialFeeInTotal("0.0%");
        } if(sumTotal>0&&sumGenFee>0){
            sumDTO.setGenericFeeInTotal(df_percent.format(sumGenFee/sumTotal));
        }else {

            sumDTO.setGenericFeeInTotal("0.0%");
        }

        //System.out.println("最终合计"+sumDTO.toString());


        String str1= JSON.toJSONString(totalList);
        String str2 = JSON.toJSONString(sumDTO);
        // 创建实例
        ReturnTwoParameterModel returnTwoParameterModel = new ReturnTwoParameterModel();

        // 返回code
        returnTwoParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject = JSONObject.parseObject(str2);
        // 传入模型.
        returnTwoParameterModel.setData(jsonArray);
        returnTwoParameterModel.setData_2(jsonObject);
        // 返回errMsg
        returnTwoParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnTwoParameterModel);
        //System.out.println(restr);

        return restr;
    }
    /**
     *  抗生素和基本药品使用分析-住院
     * @param startTime
     * @param endTime
     * @return
     */
    public String getDrlMedicinesForIp(String startTime,String endTime){

        String deptId = "";
        double sumAntFee=0,sumGenFee=0, sumTotal=0; //最终合计

        List<DepartmentDTO> deptList = drugInformationMapper.getMedicinesIpDept(startTime,  endTime);
        //将各个科室的list集合合并到一个list
        List<List<NewDrlMedicinesDTO>> totalList = new ArrayList<>();
        List<DrlMedicinesDTO> iplMedicinesList = new ArrayList<>();
        //保留两位有效小数
        DecimalFormat df = new DecimalFormat("#.00");
        //遍历科室list，根据科室id 和时间查询数据
        for(int i=0;i<deptList.size();i++){

            if(deptList.get(i)!=null){
                deptId = deptList.get(i).getDeptId();
                iplMedicinesList= drugInformationMapper.getDrlMedicinesForIp( startTime, endTime, deptId);
            }else{
                //科室为空
                iplMedicinesList  = drugInformationMapper.getDrlMedicinesForIp( startTime,  endTime,null);
                // cllMedicinesList  = drugInformationMapper.getDrlMedicinesForClNull( startTime,  endTime,null);
            }


            List <NewDrlMedicinesDTO>  newDrlMedicinesList = new ArrayList<>();
            double antibacterialFee=0.0,genericFee=0.0, total=0.0;
            String antibacterialFeeInTotal="0.0%", genericFeeInTotal="0.0%";
            //遍历list，计算抗生素和普遍药品比例
            for (int j=0;j<iplMedicinesList.size();j++){

                NewDrlMedicinesDTO newDrlMedicinesDTO = new NewDrlMedicinesDTO();
                newDrlMedicinesDTO.setDeptCode(iplMedicinesList.get(j).getDeptCode());
                newDrlMedicinesDTO.setDeptName(iplMedicinesList.get(j).getDeptName());
                newDrlMedicinesDTO.setDoctorCode(iplMedicinesList.get(j).getDoctorCode());
                newDrlMedicinesDTO.setDoctorName(iplMedicinesList.get(j).getDoctorName());
                newDrlMedicinesDTO.setAntibacterialFee(iplMedicinesList.get(j).getAntibacterialFee());
                newDrlMedicinesDTO.setGenericFee(iplMedicinesList.get(j).getGenericFee());
                newDrlMedicinesDTO.setTotal(iplMedicinesList.get(j).getTotal());
                String antFeeInTotal = "0.0%";
                String genFeeInTotal = "0.0%";

                if (iplMedicinesList.get(j).getTotal() != 0&&iplMedicinesList.get(j).getAntibacterialFee()!=0) {

                    antFeeInTotal = df_percent.format(iplMedicinesList.get(j).getAntibacterialFee() / iplMedicinesList.get(j).getTotal());
                    newDrlMedicinesDTO.setAntibacterialFeeInTotal(antFeeInTotal);

                }else {
                    newDrlMedicinesDTO.setAntibacterialFeeInTotal("0.0%");
                }
                if(iplMedicinesList.get(j).getTotal() != 0&&iplMedicinesList.get(j).getGenericFee()!=0){
                    genFeeInTotal = df_percent.format(iplMedicinesList.get(j).getGenericFee() / iplMedicinesList.get(j).getTotal());
                    newDrlMedicinesDTO.setGenericFeeInTotal(genFeeInTotal);
                } else {

                    newDrlMedicinesDTO.setGenericFeeInTotal("0.0%");
                }
                antibacterialFee+=newDrlMedicinesDTO.getAntibacterialFee();
                genericFee+=newDrlMedicinesDTO.getGenericFee();
                total+=newDrlMedicinesDTO.getTotal();

                newDrlMedicinesList.add(newDrlMedicinesDTO);
            }
            //iplMedicinesList遍历完成之后，计算科室小计，加到list最后
            NewDrlMedicinesDTO sumDrlMedicinesDTO = new NewDrlMedicinesDTO();
            sumDrlMedicinesDTO.setDoctorName("科室小计");
            sumDrlMedicinesDTO.setAntibacterialFee(Double.parseDouble(df.format(antibacterialFee)));
            sumDrlMedicinesDTO.setGenericFee(Double.parseDouble(df.format(genericFee)));
            sumDrlMedicinesDTO.setTotal(Double.parseDouble(df.format(total)));
            if(total!=0&&antibacterialFee!=0){
                antibacterialFeeInTotal= df_percent.format(antibacterialFee/total);
                sumDrlMedicinesDTO.setAntibacterialFeeInTotal(antibacterialFeeInTotal);

            }else{
                sumDrlMedicinesDTO.setAntibacterialFeeInTotal("0.0%");
            }
            if (total!=0&&genericFee!=0){
                genericFeeInTotal= df_percent.format(genericFee/total);
                sumDrlMedicinesDTO.setGenericFeeInTotal(genericFeeInTotal);
            }else {

                sumDrlMedicinesDTO.setGenericFeeInTotal("0.0%");
            }
            newDrlMedicinesList.add(sumDrlMedicinesDTO);

            //计算最终合计数据
            sumAntFee+=Double.parseDouble(df.format(antibacterialFee));
            sumGenFee+=Double.parseDouble(df.format(genericFee));
            sumTotal+=Double.parseDouble(df.format(total));


            //将各个科室的list集合合并到一个list
            totalList.add(newDrlMedicinesList);
        }

        NewDrlMedicinesDTO sumDTO = new NewDrlMedicinesDTO();

        sumDTO.setAntibacterialFee(Double.parseDouble(df.format(sumAntFee)));
        sumDTO.setGenericFee(Double.parseDouble(df.format(sumGenFee)));
        sumDTO.setTotal(Double.parseDouble(df.format(sumTotal)));
        if(sumTotal>0&&sumAntFee>0){

            sumDTO.setAntibacterialFeeInTotal(df_percent.format(sumAntFee/sumGenFee));

        }else{
            sumDTO.setAntibacterialFeeInTotal("0.0%");
        } if(sumTotal>0&&sumGenFee>0){
            sumDTO.setGenericFeeInTotal(df_percent.format(sumGenFee/sumTotal));
        }else {

            sumDTO.setGenericFeeInTotal("0.0%");
        }

        //System.out.println("最终合计"+sumDTO.toString());

        String str1= JSON.toJSONString(totalList);
        // 创建实例
        ReturnTwoParameterModel returnTwoParameterModel = new ReturnTwoParameterModel();

        // 返回code
        returnTwoParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(sumDTO));
        // 传入模型.
        returnTwoParameterModel.setData(jsonArray);
        returnTwoParameterModel.setData_2(jsonObject);
        // 返回errMsg
        returnTwoParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnTwoParameterModel);
        //System.out.println(restr);

        return restr;
    }


    /**
     *  药房药品消耗排行榜
     * @param startTime
     * @param endTime
     * @param locId
     * @return
     */
    public String getDrugConsumption(String startTime,String endTime,String locId,int pageCount, int pageSize){
        int rowcount = 0;
        NewDrDrugConsumptionDTO sumDrDrugConsumptionDTO = new NewDrDrugConsumptionDTO();
        List<NewDrDrugConsumptionDTO> newList = new ArrayList<>();
        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<DrDrugConsumptionDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<DrDrugConsumptionDTO> drDrugConsumptionDTOS = drugInformationMapper.getDrugConsumption( startTime,  endTime,  locId);
       // List<DrDrugConsumptionDTO> drDrugConsumptionDTOS = new ArrayList<>();

        if(pageCount>1){
            rowcount = (pageCount-1)*pageSize;
        }

        //如果是第一页，给图表准备数据,计算总金额
        String str1 = "";
        if(pageCount==1) {
            str1 = drugInformationUtil.getDrugConsumptionForChart(drDrugConsumptionDTOS);
            List<DrugAmountDTO> list  = drugInformationMapper.getDrugConsumptionTotalPage( startTime,  endTime,  locId);
           double totalAmount = drugInformationUtil.getTotalAmount(list);
           drugConsumtion_totalAmount = totalAmount;

        }

        //如果是最后一页，计算总合计
        if(pageCount==page.getPages()){
            if (drugConsumtion_totalAmount <= 0) {
                List<DrugAmountDTO> list  = drugInformationMapper.getDrugConsumptionTotalPage( startTime,  endTime,  locId);
                double totalAmount = drugInformationUtil.getTotalAmount(list);
                drugConsumtion_totalAmount = totalAmount;
            }else {
                sumDrDrugConsumptionDTO.setItemName("总合计");
                sumDrDrugConsumptionDTO.setAmount(drugConsumtion_totalAmount);
            }
        }else {
            sumDrDrugConsumptionDTO.setItemName("总合计");
            sumDrDrugConsumptionDTO.setAmount(-1);
        }
        //System.out.println(str1);


        //整合表格所需数据
        for(int i=0;i<drDrugConsumptionDTOS.size();i++){
            NewDrDrugConsumptionDTO newDrDrugConsumptionDTO = new NewDrDrugConsumptionDTO();
            newDrDrugConsumptionDTO.setRowCount(rowcount+i+1);
            newDrDrugConsumptionDTO.setItemCode(drDrugConsumptionDTOS.get(i).getItemCode());
            newDrDrugConsumptionDTO.setItemName(drDrugConsumptionDTOS.get(i).getItemName());
            newDrDrugConsumptionDTO.setAmount(drDrugConsumptionDTOS.get(i).getAmount());
            newDrDrugConsumptionDTO.setQuantity(drDrugConsumptionDTOS.get(i).getQuantity());
            newDrDrugConsumptionDTO.setStandard(drDrugConsumptionDTOS.get(i).getStandard());
            newDrDrugConsumptionDTO.setUnitName(drDrugConsumptionDTOS.get(i).getUnitName());
            double proportion = drDrugConsumptionDTOS.get(i).getAmount()/drugConsumtion_totalAmount;

            newDrDrugConsumptionDTO.setProportion(df_percent.format(proportion));
            newList.add(newDrDrugConsumptionDTO);
        }


        String str2= JSON.toJSONString(newList);
        String str3= JSON.toJSONString(sumDrDrugConsumptionDTO);
        // 创建实例
        ReturnThreeDataByPageModel returnThreeDataByPageModel = new ReturnThreeDataByPageModel();

        // 返回code
        returnThreeDataByPageModel.setStatusCode(200);
        returnThreeDataByPageModel.setTotalPage(page.getPages());

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str2);
        JSONObject jsonObject = JSONObject.parseObject(str1);
        JSONObject jsonObject1 = JSONObject.parseObject(str3);

        // 传入模型.
        returnThreeDataByPageModel.setData(jsonArray);
        returnThreeDataByPageModel.setData_2(jsonObject);
        returnThreeDataByPageModel.setData_3(jsonObject1);
        // 返回errMsg
        returnThreeDataByPageModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnThreeDataByPageModel);
        System.out.println(restr);

        return restr;
    }
}
