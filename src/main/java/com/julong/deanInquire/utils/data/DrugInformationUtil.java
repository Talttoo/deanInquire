package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.julong.deanInquire.dto.ReturnModel.ReturnTwoListModel;
import com.julong.deanInquire.dto.entity.drug.*;
import com.julong.deanInquire.mapper.DrugInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 药品信息数据封装工具类
 */
public class DrugInformationUtil {
    @Autowired
    DrugInformationMapper drugInformationMapper;
    DecimalFormat df = new DecimalFormat("#.00");

    /**
     * 医生药品金额排行榜-计算门诊，住院和全院总金额
     * @param list
     * @return
     */
    public DrugsFeeDataDTO getDrugsFeeData(List<DrDoctorsDrugsDTO> list){
        DrugsFeeDataDTO drugsFeeDataDTO = new  DrugsFeeDataDTO();

        double clFee = 0,ipFee = 0,totalFee = 0;
        //遍历，计算门诊，住院和全院总金额
        for(int i=0;i<list.size();i++){
            clFee+=list.get(i).getClTotal();
            ipFee+=list.get(i).getIpTotal();
            totalFee+=list.get(i).getTotal();
        }

        drugsFeeDataDTO.setClDrugFee(Double.parseDouble(df.format(clFee)));
        drugsFeeDataDTO.setIpDrugFee(Double.parseDouble(df.format(ipFee)));
        drugsFeeDataDTO.setTotalDrugFee(Double.parseDouble(df.format(totalFee)));

        return drugsFeeDataDTO;

    }

    public String getTreasuryDrugsForChart( List<DrTreasuryDrugsDTO> list){
        List<String> drug_list = new ArrayList<>();
        List<Double> amount_list = new ArrayList<>();

//        List<DrTreasuryDrugsDTO> list = new ArrayList<DrTreasuryDrugsDTO>();
//
//        Page<DrTreasuryDrugsDTO> page = PageHelper.startPage(1, 10);
//         list  = drugInformationMapper.getTreasuryDrugs(startTime, endTime, deptId);

        System.out.println("list:"+list.toString());
        ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();
        //取排行榜前十名
        if(list.size()>=10){
            for(int i=0;i<10;i++){
                drug_list.add(list.get(i).getItemName());
                amount_list.add(list.get(i).getAmount());
            }
        }else{
            for(int i=0;i<list.size();i++){
                drug_list.add(list.get(i).getItemName());
                amount_list.add(list.get(i).getAmount());
            }

        }
        String str1 = JSON.toJSONString(drug_list);
        String str2 = JSON.toJSONString(amount_list);

        JSONArray jsonArray1 = JSON.parseArray(str1);
        JSONArray jsonArray2 = JSON.parseArray(str2);


        returnTwoListModel.setList1(jsonArray1);
        returnTwoListModel.setList2(jsonArray2);

        String restr =  JSON.toJSONString(returnTwoListModel);

        return restr;


    }

    public NewDrTreasuryDrugsDTO getTreasuryDrugsTotaAmount( List<DrTreasuryDrugsDTO> list){

        double sumTotal=0;
        for(int i=0;i<list.size();i++){
            sumTotal+=list.get(i).getAmount();
        }
        NewDrTreasuryDrugsDTO sumDTO = new NewDrTreasuryDrugsDTO();
        sumDTO.setItemName("总合计");
        sumDTO.setAmount(Double.parseDouble(df.format(sumTotal)));

        return sumDTO;
    }



    public String  getDrugConsumptionForChart(List<DrDrugConsumptionDTO> list){
        List<String> drug_list = new ArrayList<>();
        List<Double> amount_list = new ArrayList<>();


        System.out.println("list:"+list.toString());
        ReturnTwoListModel returnTwoListModel = new ReturnTwoListModel();
        //取排行榜前十名
        if(list.size()>=10){
            for(int i=0;i<10;i++){
                drug_list.add(list.get(i).getItemName());
                amount_list.add(list.get(i).getAmount());
            }
        }else{
            for(int i=0;i<list.size();i++){
                drug_list.add(list.get(i).getItemName());
                amount_list.add(list.get(i).getAmount());
            }

        }
        String str1 = JSON.toJSONString(drug_list);
        String str2 = JSON.toJSONString(amount_list);

        JSONArray jsonArray1 = JSON.parseArray(str1);
        JSONArray jsonArray2 = JSON.parseArray(str2);


        returnTwoListModel.setList1(jsonArray1);
        returnTwoListModel.setList2(jsonArray2);

        String restr =  JSON.toJSONString(returnTwoListModel);

        return restr;
    }


    public double getTotalAmount ( List<DrugAmountDTO> list){
        //System.out.println("Util+++"+startTime+"-"+endTime+" locId: "+locId+"获取总合计");

      //  List<DrugAmountDTO> list  = drugInformationMapper.getDrugConsumptionTotalPage( startTime,  endTime,  locId);
       // System.out.println("size: "+list.size());
        double sumTotal=0;
        for(int i=0;i<list.size();i++){
            sumTotal+=list.get(i).getAmount();
        }
        return Double.parseDouble(df.format(sumTotal));
    }

}
