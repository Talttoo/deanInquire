package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.julong.deanInquire.dto.ReturnModel.ReturnMutiParameterModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoParameterModel;
import com.julong.deanInquire.dto.ReturnModel.page.ReturnDataByPageModel;
import com.julong.deanInquire.dto.entity.cl.*;
import com.julong.deanInquire.dto.inpram.cl.BigPrescriptionQueryPramBean;
import com.julong.deanInquire.dto.inpram.cl.DrugConsumptionPramBean;
import com.julong.deanInquire.dto.inpram.cl.DrugStatisticsPramBean;
import com.julong.deanInquire.mapper.ClInformationMapper;
import com.julong.deanInquire.utils.data.ClInformationUtil;
import com.julong.deanInquire.utils.other.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClInformationService {



    @Autowired
    ClInformationMapper clInformationMapper;

    @Autowired
    ClInformationUtil clInformationUtil;


    /**
     * 门诊业务状况分析
     * @param startTime
     * @param endTime
     * @return
     */
    public  String getBusinessCondition(String startTime, String endTime){

        List<ClBusinessConditionDTO>  clBusinessConditionDTOS = clInformationMapper.getBusinessCondition(startTime,endTime);


        //处理数据返回给前端
        String str1= clInformationUtil.getBusinessCondition(clBusinessConditionDTOS);

        // 转为JSONObject
        JSONObject jsonObject = JSONObject.parseObject(str1);

        return String.valueOf(ReturnUtil.successJson(jsonObject));


    }


    /**
     *  门诊大处方查询
     * @param startTime
     * @param endTime
     * @param cataAmount
     * @param deptId
     * @param cataId
     * @param doctorId
     * @param pageCount
     * @param pageSize
     * @return
     */
    public String getBigPrescription(String startTime, String endTime,int cataAmount,String deptId,String cataId,String doctorId,int pageCount,int pageSize){

        System.out.println("cataAmount:"+cataAmount+"   deptId: "+deptId+"   cataId:"+cataId+"   doctorId:"+doctorId);
        BigPrescriptionQueryPramBean bigPrescriptionQueryPramDTO = new BigPrescriptionQueryPramBean();
        bigPrescriptionQueryPramDTO.setStartTime(startTime);
        bigPrescriptionQueryPramDTO.setEndTIme(endTime);
        bigPrescriptionQueryPramDTO.setAmount(cataAmount);
        bigPrescriptionQueryPramDTO.setDeptId(deptId);
        bigPrescriptionQueryPramDTO.setCataId(cataId);
        bigPrescriptionQueryPramDTO.setDoctorId(doctorId);

        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<ClBigPrescriptionQueryDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<ClBigPrescriptionQueryDTO> clBigPrescriptionQueryDTOS = clInformationMapper.getBigPrescriptionByPram(bigPrescriptionQueryPramDTO);


        String str1= JSON.toJSONString(clBigPrescriptionQueryDTOS);
        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);


        return String.valueOf(ReturnUtil.successPage(jsonArray,page.getPages()));

    }


    /**
     * 门诊药品消耗趋势分析
     * @param startTime
     * @param endTime
     * @param itemId
     * @return
     */
    public String getDrugConsumption(String startTime,String endTime,String itemId){
        //标记 list是否为空
        int code = 0;
        DrugConsumptionPramBean drugConsumptionPramDTO = new DrugConsumptionPramBean();
        drugConsumptionPramDTO.setStartTime(startTime);
        drugConsumptionPramDTO.setEndTIme(endTime);
        drugConsumptionPramDTO.setItemId(itemId);


        List<ClDrugConsumptionDTO>  clDrugConsumptionDTOS = clInformationMapper.getDrugConsumptionDTO( drugConsumptionPramDTO);




        String str1 = JSON.toJSONString(clDrugConsumptionDTOS);
        //获得数量和金额
        String str2 =clInformationUtil.getQuanlityAndAmount(clDrugConsumptionDTOS);


        // 创建实例
        ReturnTwoParameterModel returnParameterModel = new ReturnTwoParameterModel();

        // 判断list是否为空，返回code
        if(clDrugConsumptionDTOS.size()==0){
            returnParameterModel.setStatusCode(100);
        }else {
            returnParameterModel.setStatusCode(200);
        }

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        // 转为JSONArray
        JSONObject jsonObject = JSONObject.parseObject(str2);
        // JSONArray jsonArray2= JSONArray.parseArray(str2);

        // 传入模型.
        returnParameterModel.setData(jsonArray);
        returnParameterModel.setData_2(jsonObject);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);

       // System.out.println(restr);

        return restr;

    }

    /**
     *  门诊药品统计
     * @param startTime
     * @param endTime
     * @param statisticType
     * @param order
     * @return
     */
    public String getDrugStatistics(String startTime,String endTime,int statisticType,String  order,int pageCount,int pageSize ){
        int rouNum = 0;
        List<ClDrugStatisticsDTO> newList = new ArrayList<>();
        //根据页数计算行号
        if(pageCount==1){//第一页
            rouNum=0;
        }else{//第二页之后
            rouNum=(pageCount-1)*pageSize;
        }
        //请求参数
        DrugStatisticsPramBean drugStatisticsPramBean = new DrugStatisticsPramBean();
        drugStatisticsPramBean.setStartTime(startTime);
        drugStatisticsPramBean.setEndTIme(endTime);
        drugStatisticsPramBean.setStatisticType(statisticType);
        drugStatisticsPramBean.setOrder(order);
        System.out.println(drugStatisticsPramBean);
        //调用
        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<ClBigPrescriptionQueryDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<ClDrugStatisticsDTO> drugStaList = clInformationMapper.getDrugStatistics(drugStatisticsPramBean);

        //遍历，计算行号
        for(int i=0;i<drugStaList.size();i++){
            ClDrugStatisticsDTO clDrugStatisticsDTO = new ClDrugStatisticsDTO();
            clDrugStatisticsDTO.setRowNum(rouNum+1+i);
            clDrugStatisticsDTO.setItemCode(drugStaList.get(i).getItemCode());
            clDrugStatisticsDTO.setItemName(drugStaList.get(i).getItemName());
            clDrugStatisticsDTO.setAmount(drugStaList.get(i).getAmount());
            clDrugStatisticsDTO.setQuantity(drugStaList.get(i).getQuantity());
            clDrugStatisticsDTO.setStandard(drugStaList.get(i).getStandard());
            clDrugStatisticsDTO.setUnitName(drugStaList.get(i).getUnitName());
           newList.add(clDrugStatisticsDTO);

        }



        String str1= JSON.toJSONString(newList);

        // 创建实例
        ReturnDataByPageModel returnParameterModel = new ReturnDataByPageModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);

        //返回总页数
        returnParameterModel.setTotalPage(page.getPages());

        // 传入模型.
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);

        //System.out.println(restr);

        return restr;
    }


    /**
     *  门诊量分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String getVolumeAnalysis(String startTime, String endTime){



        List<ClVolumeAnalysisDTO> clVolumeAnalysisDTOS = clInformationMapper.getVolumeAnalysis(startTime,endTime);

        List<ClGenderAnalysisDTO> clGenderAnalysisDTOS = clInformationMapper.getGenderAnalysis(startTime,endTime);

        List<ClDateAnalysisDTO> clDateAnalysisDTOS =clInformationMapper.getDateAnalysis(startTime,endTime);

        //封装科室数据
        String str1 = clInformationUtil.getdeptDataList(clVolumeAnalysisDTOS);

        String str2 = JSON.toJSONString(clGenderAnalysisDTOS);
        //封装日期数据
        String str3 = clInformationUtil.getDateDataList(clDateAnalysisDTOS);

        // 创建实例
        ReturnMutiParameterModel returnParameterModel = new ReturnMutiParameterModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONObject jsonObject1 = JSONObject.parseObject(str1);
        JSONArray jsonArray2= JSONArray.parseArray(str2);
        JSONObject jsonObject3 = JSONObject.parseObject(str3);

        // 传入模型.
        returnParameterModel.setData(jsonObject1);
        returnParameterModel.setData_2(jsonArray2);
        returnParameterModel.setData_3(jsonObject3);


        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);

        //System.out.println(restr);

        return restr;

    }



}
