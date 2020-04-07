package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnThreeListModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoListModel;
import com.julong.deanInquire.dto.entity.cl.*;
import com.julong.deanInquire.dto.utils.ReturnDrugListDTO;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 门诊数据封装工具
 */
@Component
public class ClInformationUtil {
    DecimalFormat df = new DecimalFormat("#.00");

    /**
     * 门诊业务状况分析-组装前端所需要的数据
     * @param list
     * @return
     */
    public String getBusinessCondition(List<ClBusinessConditionDTO> list){
        List<NewClBusinessConditionDTO> myList = new ArrayList<>();
        NewClBusinessConditionDTO sumDTO = new NewClBusinessConditionDTO();//总合计
        int clTimes =0;//
        double xyFee=0, zyFee=0, ylFee=0,totalFee=0, sumAvgFee=0,sumAvgZyFee=0,sumAvgXyFee=0,sumAvgYlFee=0, xyTimes=0, zyTimes=0, ylTimes=0;
        //遍历，计算每个科室的费用平均值，重新封装数据
        for(int i=0; i<list.size();i++){

            //计算每个科室的费用平均值
            NewClBusinessConditionDTO newDTO = new NewClBusinessConditionDTO();
            double avgFee=0,avgZyFee=0,avgXyFee=0,avgYlFee=0;
            newDTO.setDept(list.get(i).getDept());
            newDTO.setDeptCode(list.get(i).getDeptCode());
            newDTO.setDeptName(list.get(i).getDeptName());
            newDTO.setClTimes(list.get(i).getClTimes());
            newDTO.setTotalFee(list.get(i).getTotalFee());
            avgFee=list.get(i).getTotalFee()/list.get(i).getClTimes();
            newDTO.setAvgFee(Double.parseDouble(df.format(avgFee)));
            newDTO.setZyFee(list.get(i).getZyFee());
            newDTO.setXyFee(list.get(i).getXyFee());
            newDTO.setYlFee(list.get(i).getYlFee());
            newDTO.setZyTimes(list.get(i).getZyTimes());
            newDTO.setXyTimes(list.get(i).getXyTimes());
            newDTO.setYlTimes(list.get(i).getYlTimes());
            //如果住院人数不为零，则计算平均值
            if(list.get(i).getZyTimes()!=0){
                avgZyFee=list.get(i).getZyFee()/list.get(i).getZyTimes();
            }else{
                avgZyFee=0.0;
            }
            //如果药品次数不为零，则计算平均值
            if(list.get(i).getXyTimes()!=0){
                avgXyFee=list.get(i).getXyFee()/list.get(i).getXyTimes();
            }else{
                avgXyFee=0.0;
            }
            //如果医疗人数不为零，则计算平均值
            if(list.get(i).getYlTimes()!=0){
                avgYlFee=list.get(i).getYlFee()/list.get(i).getYlTimes();
            }else{
                avgYlFee=0.0;
            }



            newDTO.setAvgXyFee(Double.parseDouble(df.format(avgXyFee)));
            newDTO.setAvgZyFee(Double.parseDouble(df.format(avgZyFee)));
            newDTO.setAvgYlFee(Double.parseDouble(df.format(avgYlFee)));
            newDTO.setXyMaxAmount(list.get(i).getXyMaxAmount());
            newDTO.setZyMaxAmount(list.get(i).getZyMaxAmount());
            newDTO.setYlMaxAmount(list.get(i).getYlMaxAmount());

            myList.add(newDTO);

            //计算合计
            clTimes+=list.get(i).getClTimes();
            xyFee+=list.get(i).getXyFee();
            zyFee+=list.get(i).getZyFee();
            ylFee+=list.get(i).getYlFee();
            totalFee+=list.get(i).getTotalFee();
//            xyMaxAmount+=list.get(i).getXyMaxAmount();
//            zyMaxAmount+=list.get(i).getZyMaxAmount();
//            ylMaxAmount+=list.get(i).getYlMaxAmount();
            xyTimes+=list.get(i).getXyTimes();
            zyTimes+=list.get(i).getZyTimes();
            ylTimes+=list.get(i).getYlTimes();

        }
        sumDTO.setDeptName("合计");
        sumDTO.setClTimes(clTimes);
        sumDTO.setXyFee(Double.parseDouble(df.format(xyFee)));
        sumDTO.setZyFee(Double.parseDouble(df.format(zyFee)));
        sumDTO.setYlFee(Double.parseDouble(df.format(ylFee)));
        sumDTO.setTotalFee(Double.parseDouble(df.format(totalFee)));

        //计算合计的平均值
        if(clTimes==0){//如果门诊次数为零
            sumAvgFee=0.00;
            sumAvgZyFee=0.00;
            sumAvgXyFee=0.00;
            sumAvgYlFee=0.00;
        }else {//门诊次数不为零
            if(totalFee!=0){
                sumAvgFee=totalFee/clTimes;
            }else {
                sumAvgFee=0.00;
            }
            if(zyFee!=0){
                sumAvgZyFee=zyFee/zyTimes;
            } else {
                sumAvgZyFee=0.00;
            }

            if(xyFee!=0){
                sumAvgXyFee=xyFee/xyTimes;
            }else{
                sumAvgXyFee=0.00;
            }
            if(ylFee!=0){
                sumAvgYlFee=ylFee/ylTimes;
            }else{
                sumAvgYlFee=0.00;
            }


        }

        //保留两位有效小数
        sumDTO.setAvgFee(Double.parseDouble(df.format(sumAvgFee)));
        sumDTO.setAvgZyFee(Double.parseDouble(df.format(sumAvgZyFee)));
        sumDTO.setAvgXyFee(Double.parseDouble(df.format(sumAvgXyFee)));
        sumDTO.setAvgYlFee(Double.parseDouble(df.format(sumAvgYlFee)));
        sumDTO.setXyTimes(Double.parseDouble(df.format(xyTimes)));
        sumDTO.setZyTimes(Double.parseDouble(df.format(zyTimes)));
        sumDTO.setYlTimes(Double.parseDouble(df.format(ylTimes)));

        //转为json格式
        String str1 = JSON.toJSONString(myList);
        String str2 = JSON.toJSONString(sumDTO);

        JSONArray jsonArray = JSON.parseArray(str1);
        JSONObject jsonObject = JSON.parseObject(str2);

        ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();
        returnTwoListModel.setList1(jsonArray);
        returnTwoListModel.setList2(jsonObject);

        String restr = JSON.toJSONString(returnTwoListModel);
        return restr;

    }


    /**
     * 门诊量分析-将科室的有关数据，转成前端图表所需要的数据格式
     * @param list
     * @return
     */
    public String getdeptDataList(List<ClVolumeAnalysisDTO> list){
        ReturnThreeListModel returnThreeListModel = new ReturnThreeListModel();
        //科室名称list
        List<String> list_dept = new ArrayList<>();
        //各个科室数据list
        List<Integer> list_data = new ArrayList<>();
        //遍历，取出数据
        for (int i= 0; i<list.size();i++){
            list_dept.add(list.get(i).getDeptName());
            list_data.add(list.get(i).getClTimes());
        }

        String str1= JSON.toJSONString(list);
        String str2= JSON.toJSONString(list_dept);
        String str3= JSON.toJSONString(list_data);

        // 转为JSONArray
        JSONArray jsonArray1= JSONArray.parseArray(str1);
        JSONArray jsonArray2= JSONArray.parseArray(str2);
        JSONArray jsonArray3= JSONArray.parseArray(str3);

        returnThreeListModel.setList1(jsonArray1);
        returnThreeListModel.setList2(jsonArray2);
        returnThreeListModel.setList3(jsonArray3);

        String restr = JSON.toJSONString(returnThreeListModel);

       // System.out.println(restr);

        return restr;

    }

    /**
     * 门诊量分析-将每天的有关数据，转成前端图表所需要的数据格式
     * @param list
     * @return
     */
    public String getDateDataList(List<ClDateAnalysisDTO> list){

        ReturnThreeListModel returnThreeListModel = new ReturnThreeListModel();
        //日期list
        List<String> list_date = new ArrayList<>();
        //日期对应的数据list
        List<Integer> list_data = new ArrayList<>();
        //遍历，取出数据
        for (int i= 0; i<list.size();i++){
            list_date.add(list.get(i).getRegdate());
            list_data.add(list.get(i).getClTimes());
        }

        String str1= JSON.toJSONString(list);
        String str2= JSON.toJSONString(list_date);
        String str3= JSON.toJSONString(list_data);

        // 转为JSONArray
        JSONArray jsonArray1= JSONArray.parseArray(str1);
        JSONArray jsonArray2= JSONArray.parseArray(str2);
        JSONArray jsonArray3= JSONArray.parseArray(str3);

        returnThreeListModel.setList1(jsonArray1);
        returnThreeListModel.setList2(jsonArray2);
        returnThreeListModel.setList3(jsonArray3);

        String restr = JSON.toJSONString(returnThreeListModel);

        //System.out.println(restr);

        return restr;

    }


    /**
     *门诊药品消耗趋势分析-组装前端图表所需要的数据
     * @param list
     * @return
     */
    public String getQuanlityAndAmount(List<ClDrugConsumptionDTO> list){
        ReturnDrugListDTO returnDrugListDTO = new ReturnDrugListDTO();

        List<Double> amountList = new ArrayList<>();//金额list
        List<Integer> quanlityList = new ArrayList<>();//数量List
        List<String> timeList = new ArrayList<>();//时间list
        //遍历，取出数据
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
