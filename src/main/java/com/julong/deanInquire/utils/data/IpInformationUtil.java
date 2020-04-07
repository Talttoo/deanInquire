package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnThreeListModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoListModel;
import com.julong.deanInquire.dto.entity.ip.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 住院信息数据封装工具类
 */
public class IpInformationUtil {
    /**
     *  住院收入分析 - 日期分析
     * @param list
     * @return
     */
    public String getSettlementIncomeByDate(List<IpSettlementIncomeDTO> list){

        ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();


        List<String> list_date = new ArrayList<>();
        List<Double> list_data = new ArrayList<>();
        for (int i = 0; i<list.size();i++){
            list_date.add(list.get(i).getChargeDay());
            list_data.add(list.get(i).getTotalSum());
        }

        String str1= JSON.toJSONString(list_date);
        String str2= JSON.toJSONString(list_data);


        // 转为JSONArray
        JSONArray jsonArray1= JSONArray.parseArray(str1);
        JSONArray jsonArray2= JSONArray.parseArray(str2);

        returnTwoListModel.setList1(jsonArray1);
        returnTwoListModel.setList2(jsonArray2);

        String restr = JSON.toJSONString(returnTwoListModel);

        return restr;
    }

    /**
     *  住院收入分析 - 科室分析
     * @param list
     * @return
     */
    public String getSettlementIncomeByDept(List<IpSettlementIncomeByDeptDTO> list){

        ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();

        List<String> list_dept = new ArrayList<>();
        List<Double> list_data = new ArrayList<>();

        for (int i = 0; i<list.size();i++){
            list_dept.add(list.get(i).getDeptName());
            list_data.add(list.get(i).getTotalSum());
        }

        String str1= JSON.toJSONString(list_dept);
        String str2= JSON.toJSONString(list_data);


        // 转为JSONArray
        JSONArray jsonArray1= JSONArray.parseArray(str1);
        JSONArray jsonArray2= JSONArray.parseArray(str2);

        returnTwoListModel.setList1(jsonArray1);
        returnTwoListModel.setList2(jsonArray2);

        String restr = JSON.toJSONString(returnTwoListModel);

        return restr;
    }

     public String getIpDrugRevenueRatio(List<IpDrugRevenueRatioDTO> list){
        List<New_IpDrugRevenueRatioDTO> newList = new ArrayList<>();

       double allTotal = 0.0;
        //表尾合计数据类
       DrugRevenueSumDTO drugRevenueSumDTO = new DrugRevenueSumDTO();

       double totalFee = 0, drugFee = 0, drugProportion = 0;

       for(int j = 0; j<list.size();j++){
           allTotal+=list.get(j).getTotalSum();
       }

        for(int i = 0; i<list.size();i++){
            New_IpDrugRevenueRatioDTO new_ipDrugRevenueRatioDTO = new New_IpDrugRevenueRatioDTO();
            new_ipDrugRevenueRatioDTO.setDeptCode(list.get(i).getDeptCode());
            new_ipDrugRevenueRatioDTO.setDeptName(list.get(i).getDeptName());
            new_ipDrugRevenueRatioDTO.setDrugFee(list.get(i).getDrugFee());
            new_ipDrugRevenueRatioDTO.setTotalSum(list.get(i).getTotalSum());
            if(list.get(i).getTotalSum()>0) {
                double drugIndept = ((double) list.get(i).getDrugFee()/list.get(i).getTotalSum())*100;
                new_ipDrugRevenueRatioDTO.setDrugFeeInDept(String.format("%.2f", drugIndept));

            }else{
                new_ipDrugRevenueRatioDTO.setDrugFeeInDept("0%");
            }

            if(allTotal>0){
                double drugInIp = ((double) list.get(i).getDrugFee()/allTotal)*100;
                new_ipDrugRevenueRatioDTO.setDrugFeeInIp(String.format("%.2f", drugInIp) );
            }else{
                new_ipDrugRevenueRatioDTO.setDrugFeeInIp( "0");
            }


            newList.add(new_ipDrugRevenueRatioDTO);

        }
         //表尾合计数据totalFee = 0, drugFee = 0, drugProportion = 0;
         for (int j=0;j<newList.size();j++){
             totalFee+=newList.get(j).getTotalSum();
             drugFee+=newList.get(j).getDrugFee();
             drugProportion+= Double.parseDouble(newList.get(j).getDrugFeeInIp());
         }
         DecimalFormat df = new DecimalFormat("#.00");
         drugRevenueSumDTO.setDrugFee(Double.parseDouble(df.format(drugFee)));
         drugRevenueSumDTO.setTotalFee(Double.parseDouble(df.format(totalFee)));
         drugRevenueSumDTO.setDrugFeeProportion(String.valueOf(drugProportion)+"%");



         ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();

         String str1 = JSON.toJSONString(newList);
         String str2 = JSON.toJSONString(drugRevenueSumDTO);


         JSONArray jsonArray = JSON.parseArray(str1);
         JSONObject jsonObject = JSON.parseObject(str2);

         returnTwoListModel.setList1(jsonArray);
         returnTwoListModel.setList2(jsonObject);

         String restr = JSON.toJSONString(returnTwoListModel);
         System.out.println(newList.toString());
        return restr;

     }
    public String getIpDrugRevenueRatioForChart(List<IpDrugRevenueRatioDTO> list){

        List<String> dept_list = new ArrayList<>();
        List<Double> drugFee_list = new ArrayList<>();
        List<Double> medFee_list = new ArrayList<>();



        for(int i= 0 ; i<list.size(); i++){
            dept_list.add(list.get(i).getDeptName());
            drugFee_list.add(list.get(i).getDrugFee());
            medFee_list.add(list.get(i).getTotalSum()-list.get(i).getDrugFee());

        }

        ReturnThreeListModel returnThreeListModel = new ReturnThreeListModel();

        String str1 = JSON.toJSONString(dept_list);
        String str2 = JSON.toJSONString(drugFee_list);
        String str3 = JSON.toJSONString(medFee_list);

        JSONArray jsonArray1 = JSONArray.parseArray(str1);
        JSONArray jsonArray2 = JSONArray.parseArray(str2);
        JSONArray jsonArray3 = JSONArray.parseArray(str3);
        returnThreeListModel.setList1(jsonArray1);
        returnThreeListModel.setList2(jsonArray2);
        returnThreeListModel.setList3(jsonArray3);




        String restr = JSON.toJSONString(returnThreeListModel);

        return restr;

    }


}
