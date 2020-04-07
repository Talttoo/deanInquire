package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnFiveListModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnSixListModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoListModel;
import com.julong.deanInquire.dto.entity.fs.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FinancialStatusUtil {
    DecimalFormat df = new DecimalFormat("#.00");
    DecimalFormat df_percent = new DecimalFormat("0.00%");
    public String getHospitalIncome(List<FsHospitalIncomeDTO> list){

        List<String> deptList = new ArrayList<>();
        List<Double> dataList  = new ArrayList<>();
        List<FsHosIncForChartDTO> pieChartList = new ArrayList<>();
        List<NewFsHospitalIncomeDTO> newFsHospitalIncomeDTOList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.00");
        double totalAmount = 0;

        for(int i=0;i<list.size();i++){
            if(list.get(i).getDeptName()==null){
                deptList.add("null");
            }else{
                deptList.add(list.get(i).getDeptName());
            }

            dataList.add(list.get(i).getTotal());
            totalAmount+= list.get(i).getTotal();
        }

        for (int j=0;j<list.size();j++){
            NewFsHospitalIncomeDTO newFsHospitalIncomeDTO = new NewFsHospitalIncomeDTO();
            FsHosIncForChartDTO fsHosIncForChartDTO = new FsHosIncForChartDTO();

            fsHosIncForChartDTO.setName(list.get(j).getDeptName());
            fsHosIncForChartDTO.setData(list.get(j).getTotal());

            newFsHospitalIncomeDTO.setDeptCode(list.get(j).getDeptCode());
            newFsHospitalIncomeDTO.setDeptName(list.get(j).getDeptName());
            newFsHospitalIncomeDTO.setTotal(list.get(j).getTotal());

            if (totalAmount!=0&&list.get(j).getTotal()!=0){
                newFsHospitalIncomeDTO.setProportion(df_percent.format((list.get(j).getTotal()/totalAmount)));
            }else {
                newFsHospitalIncomeDTO.setProportion("0%");
            }

            pieChartList.add(fsHosIncForChartDTO);

            newFsHospitalIncomeDTOList.add(newFsHospitalIncomeDTO);

        }
        //科室总合计
        TotalAmountDTO totalAmountDTO = new TotalAmountDTO();
        totalAmountDTO.setTotalAmount(Double.parseDouble(df.format(totalAmount)));


        ReturnFiveListModel returnFiveListModel = new ReturnFiveListModel();

        String str1 = JSON.toJSONString(deptList);
        String str2 = JSON.toJSONString(dataList);
        String str3 = JSON.toJSONString(newFsHospitalIncomeDTOList);
        String str4 = JSON.toJSONString(pieChartList);

        //住院人数合计
        String str5 = JSON.toJSONString(totalAmountDTO);

        JSONArray jsonArray1 = JSONArray.parseArray(str1);
        JSONArray jsonArray2 = JSONArray.parseArray(str2);
        JSONArray jsonArray3 = JSONArray.parseArray(str3);
        JSONArray jsonArray4 = JSONArray.parseArray(str4);
        //JSONArray jsonArray5 = JSONArray.parseArray(str5);
        JSONObject jsonObject = JSONObject.parseObject(str5);
        returnFiveListModel.setList1(jsonArray1);
        returnFiveListModel.setList2(jsonArray2);
        returnFiveListModel.setList3(jsonArray3);
        returnFiveListModel.setList4(jsonArray4);
        returnFiveListModel.setList5(jsonObject);


        String restr = JSON.toJSONString(returnFiveListModel);
       // System.out.println(restr);
        return restr;


    }


    public String getPatientArrears(List<FsPatientArrearsDTO> list){

       List<String> deptList = new ArrayList<>();//科室list
       List<Double> totalList = new ArrayList<>();//合计list
       List<Double> depositList = new ArrayList<>();//预交款list
       List<Double> badDebtList = new ArrayList<>();//坏账list
       List<NewPatientArrearsDTO> newPatientArrearsDTOList = new ArrayList<>();

       double sumTotal=0,sumDeposit=0,sumsBalanceOrArrears=0,sumBadDebt=0;
        //遍历，组装各数据
        for (int i=0;i<list.size();i++){
            //表格数据
            NewPatientArrearsDTO  newPatientArrearsDTO = new NewPatientArrearsDTO();
            newPatientArrearsDTO.setDeptCode(list.get(i).getDeptCode());
            newPatientArrearsDTO.setDeptName(list.get(i).getDeptName());
            newPatientArrearsDTO.setDeposit(list.get(i).getDeposit());
            newPatientArrearsDTO.setTotal(list.get(i).getTotal());
            double BalanceOrArrears=0,badDebt=0;
            BalanceOrArrears=Double.parseDouble(df.format(list.get(i).getDeposit()-list.get(i).getTotal()));
            //欠款或结余
            if(BalanceOrArrears>=0){
                badDebt = 0 ;
            }else {
                badDebt = BalanceOrArrears;
            }
            newPatientArrearsDTO.setBalanceOrArrears(BalanceOrArrears);
            newPatientArrearsDTO.setBadDebt(badDebt);

            //总合计数据
            sumTotal+=list.get(i).getTotal();
            sumDeposit+=list.get(i).getDeposit();
            sumsBalanceOrArrears+=BalanceOrArrears;
            sumBadDebt+=badDebt;

            //柱状图数据
            deptList.add(list.get(i).getDeptName());
            totalList.add(list.get(i).getTotal());
            depositList.add(list.get(i).getDeposit());
            badDebtList.add(badDebt);



            //表格数据
            newPatientArrearsDTOList.add(newPatientArrearsDTO);

        }
        //全院合计
        NewPatientArrearsDTO  sumDTO = new NewPatientArrearsDTO();
        sumDTO.setDeptName("合计");
        sumDTO.setTotal(Double.parseDouble(df.format(sumTotal)));
        sumDTO.setDeposit(Double.parseDouble(df.format(sumDeposit)));
        sumDTO.setBalanceOrArrears(Double.parseDouble(df.format(sumsBalanceOrArrears)));
        sumDTO.setBadDebt(Double.parseDouble(df.format(sumBadDebt)));


        ReturnSixListModel returnSixListModel = new ReturnSixListModel();


        String str1 = JSON.toJSONString(newPatientArrearsDTOList);
        String str2 = JSON.toJSONString(deptList);
        String str3 = JSON.toJSONString(totalList);
        String str4 = JSON.toJSONString(depositList);
        String str5 = JSON.toJSONString(badDebtList);
        String str6 = JSON.toJSONString(sumDTO);

        JSONArray jsonArray1 = JSON.parseArray(str1);
        JSONArray jsonArray2 = JSON.parseArray(str2);
        JSONArray jsonArray3 = JSON.parseArray(str3);
        JSONArray jsonArray4 = JSON.parseArray(str4);
        JSONArray jsonArray5 = JSON.parseArray(str5);
        JSONObject jsonObject = JSON.parseObject(str6);


        returnSixListModel.setList1(jsonArray1);
        returnSixListModel.setList2(jsonArray2);
        returnSixListModel.setList3(jsonArray3);
        returnSixListModel.setList4(jsonArray4);
        returnSixListModel.setList5(jsonArray5);
        returnSixListModel.setList6(jsonObject);


        return JSON.toJSONString(returnSixListModel);
    }

    public String getPatientArrearsByPatient( List<FsPatientArrearsByPatientDTO> list){
        FsPatientArrearsByPatientDTO  sumDTO = new  FsPatientArrearsByPatientDTO();
        double sumTotal = 0.0,sumDeposit = 0.0,sumBadDebt = 0.0;
        List<FsPatientArrearsByPatientDTO> newList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            FsPatientArrearsByPatientDTO  patientDTO = new  FsPatientArrearsByPatientDTO();
            patientDTO.setEncounterID(list.get(i).getEncounterID());
            patientDTO.setDeptName(list.get(i).getDeptName());
            patientDTO.setIpNo(list.get(i).getIpNo());
            patientDTO.setIpCount(list.get(i).getIpCount());
            patientDTO.setName(list.get(i).getName());
            patientDTO.setInDate(list.get(i).getInDate());
            patientDTO.setOutDate(list.get(i).getOutDate());
            patientDTO.setTotal(list.get(i).getTotal());
            patientDTO.setDeposit(list.get(i).getDeposit());
            patientDTO.setBadDebt(Double.parseDouble(df.format(list.get(i).getDeposit()-list.get(i).getTotal())));
            newList.add(patientDTO);


            sumTotal+=list.get(i).getTotal();
            sumDeposit+=list.get(i).getDeposit();
            sumBadDebt+=Double.parseDouble(df.format(list.get(i).getDeposit()-list.get(i).getTotal()));

        }

        sumDTO.setEncounterID("合计");
        sumDTO.setTotal(Double.parseDouble(df.format(sumTotal)));
        sumDTO.setDeposit(Double.parseDouble(df.format(sumDeposit)));
        sumDTO.setBadDebt(Double.parseDouble(df.format(sumBadDebt)));


        ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();

        String str1 = JSON.toJSONString(newList);
        String str2 = JSON.toJSONString(sumDTO);

        JSONArray jsonArray1 = JSON.parseArray(str1);
        JSONObject jsonObject = JSON.parseObject(str2) ;

        returnTwoListModel.setList1(jsonArray1);
        returnTwoListModel.setList2(jsonObject);

        return JSON.toJSONString(returnTwoListModel);

    }
}
