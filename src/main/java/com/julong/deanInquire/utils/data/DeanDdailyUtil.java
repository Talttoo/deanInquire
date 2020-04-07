package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnFourListModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.entity.dean.DeAllStaffBusinessDTO;
import com.julong.deanInquire.dto.entity.dean.DeClDailyDynamicsDTO;
import com.julong.deanInquire.dto.entity.dean.DeClWaitingQueueDTO;
import com.julong.deanInquire.dto.entity.dean.DeNewAllStaffBusinessDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 院长日报数据封装工具类
 */
@Component
public class DeanDdailyUtil {
    /**
     * 当天全体业务动态-封装返回数据
     * @param deAllStaffBusinessDTO
     * @return
     */
    public String getAllStaffBusiness(DeAllStaffBusinessDTO deAllStaffBusinessDTO){
        //计算数据库没有的数据
        DeNewAllStaffBusinessDTO newAllStaffBusinessDTO = new  DeNewAllStaffBusinessDTO();

        newAllStaffBusinessDTO.setCl_erTimes(deAllStaffBusinessDTO.getCl_erTimes());
        newAllStaffBusinessDTO.setCl_gopTimes(deAllStaffBusinessDTO.getCl_gopTimes());
        newAllStaffBusinessDTO.setCl_totalTimes(deAllStaffBusinessDTO.getCl_erTimes()+deAllStaffBusinessDTO.getCl_gopTimes());

        newAllStaffBusinessDTO.setCl_recipeTotalFee(deAllStaffBusinessDTO.getCl_totalFee());
        newAllStaffBusinessDTO.setCl_times(deAllStaffBusinessDTO.getCl_times());
        //平均人次金额
        if(deAllStaffBusinessDTO.getCl_times()!=0) {//门诊人次是否为零
            newAllStaffBusinessDTO.setCl_perAmount((double)deAllStaffBusinessDTO.getCl_totalFee() / deAllStaffBusinessDTO.getCl_times());
        }else{
            newAllStaffBusinessDTO.setCl_perAmount(0);
        }

        newAllStaffBusinessDTO.setCl_totalFee(deAllStaffBusinessDTO.getCl_totalFee());
        newAllStaffBusinessDTO.setCl_drugFee(deAllStaffBusinessDTO.getCl_drugFee());
        //计算门诊药品金额所占比例
        if(deAllStaffBusinessDTO.getCl_totalFee()!=0) {//门诊总费用是否为零
            double drug_proportion = ((double)deAllStaffBusinessDTO.getCl_drugFee() / deAllStaffBusinessDTO.getCl_totalFee()) * 100;
            newAllStaffBusinessDTO.setCl_drugInTotal(String.format("%.2f", drug_proportion) + "%");
        }else {
            newAllStaffBusinessDTO.setCl_drugInTotal("0%");
        }

        newAllStaffBusinessDTO.setIp_inTimes(deAllStaffBusinessDTO.getIp_inTimes());
        newAllStaffBusinessDTO.setIp_existTimes(deAllStaffBusinessDTO.getIp_existTimes());
        newAllStaffBusinessDTO.setIp_outTimes(deAllStaffBusinessDTO.getIp_outTimes());

        newAllStaffBusinessDTO.setIp_totalBed(deAllStaffBusinessDTO.getIp_totalBed());
        newAllStaffBusinessDTO.setIp_useBed(deAllStaffBusinessDTO.getIp_useBed());
        //计算床位占用率
        if(deAllStaffBusinessDTO.getIp_totalBed()!=0) {//总床位是否为零
            double bed_useProportion = ((double)deAllStaffBusinessDTO.getIp_useBed()/deAllStaffBusinessDTO.getIp_totalBed())*100;
            System.out.println(bed_useProportion);
            newAllStaffBusinessDTO.setBed_useProportion(String.format("%.2f", bed_useProportion));
        }else{
            newAllStaffBusinessDTO.setBed_useProportion( "0%");
        }

        newAllStaffBusinessDTO.setIp_totalFee(deAllStaffBusinessDTO.getIp_totalFee());
        newAllStaffBusinessDTO.setIp_drugFee(deAllStaffBusinessDTO.getIp_drugFee());
        //计算住院药品费用占住院总费用比例
        if(deAllStaffBusinessDTO.getIp_totalFee()!=0) {
            double Ip_drugInTotalProportion = ((double)deAllStaffBusinessDTO.getIp_drugFee()/deAllStaffBusinessDTO.getIp_totalFee()) * 100;
            newAllStaffBusinessDTO.setIp_drugInTotal(String.format("%.2f", Ip_drugInTotalProportion) + "%");
        }else {
            newAllStaffBusinessDTO.setIp_drugInTotal("0%");
        }

        newAllStaffBusinessDTO.setAll_totalFee(deAllStaffBusinessDTO.getCl_totalFee()+deAllStaffBusinessDTO.getIp_totalFee());
        newAllStaffBusinessDTO.setAll_drugFee(deAllStaffBusinessDTO.getCl_drugFee()+deAllStaffBusinessDTO.getIp_drugFee());
        //计算总药品费用占全院收入比例
        if (newAllStaffBusinessDTO.getAll_totalFee()!=0) {
            double all_drugInTotalProportion = ((double)newAllStaffBusinessDTO.getAll_drugFee() / newAllStaffBusinessDTO.getAll_totalFee()) * 100;
            newAllStaffBusinessDTO.setAll_drugInTotal(String.format("%.2f", all_drugInTotalProportion) + "%");
        }else{
            newAllStaffBusinessDTO.setAll_drugInTotal( "0%");
        }


        String str1= JSON.toJSONString(newAllStaffBusinessDTO);
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
       // System.out.println(restr);
        return restr;

    }

    /**
     * 门诊每日动态-封装返回数据
     * @param deClDailyDynamicsDTOS
     * @return
     */
   public String  getClDailyDynamicData(List<DeClDailyDynamicsDTO> deClDailyDynamicsDTOS){
        //总门急诊量
       int totalTimes = 0;

       //门诊量
       int clTimes = 0;
       List<Integer> clDataList = new  ArrayList();
       //急诊量
       int emTimes = 0;
       List<Integer> emDataList = new  ArrayList();


       //门急诊数据
       List<DeClDailyDynamicsDTO> list =createData(deClDailyDynamicsDTOS);

       String str1=JSON.toJSONString(list);

        //遍历
       for(int j = 0 ; j < list.size() ; j++) {

           //计算门诊人次总数
           if(list.get(j).getGopTimes()!=""){
               clDataList.add(j, Integer.valueOf(list.get(j).getGopTimes()));
               clTimes+=Integer.parseInt(list.get(j).getGopTimes());
           }else{
               clDataList.add(j, 0);
           }

            //计算急诊人次总数
           if(list.get(j).getErTimes()!=""){
               emDataList.add(j, Integer.valueOf(list.get(j).getErTimes()));
               emTimes+=Integer.parseInt(list.get(j).getErTimes());
           }else {
               emDataList.add(j, 0);
           }

       }

       String str2=JSON.toJSONString(clDataList);
       String str3=JSON.toJSONString(emDataList);

       JSONObject jsonObject=new JSONObject();
       jsonObject.put("clTimes",clTimes);
       jsonObject.put("emTimes",emTimes);
       jsonObject.put("totalTimes",clTimes+emTimes);




       ReturnFourListModel returnFourListModel = new ReturnFourListModel();

       // 转为JSONArray
       JSONArray jsonArray1= JSONArray.parseArray(str1);

       JSONArray jsonArray2= JSONArray.parseArray(str2);

       JSONArray jsonArray3= JSONArray.parseArray(str3);

       returnFourListModel.setList1(jsonArray1);
       returnFourListModel.setList2(jsonArray2);
       returnFourListModel.setList3(jsonArray3);
       returnFourListModel.setList4(jsonObject);

       String restr  = JSON.toJSONString(returnFourListModel);
      //System.out.println(restr);
        return restr;
    }

    /**
     * 门诊等候队列-将数据转成24小时的数据
     * @param list
     * @return
     */
    public List<DeClDailyDynamicsDTO> createData(List<DeClDailyDynamicsDTO> list){
        List<DeClDailyDynamicsDTO> myList = new ArrayList();

        //初始化24小时的数据
        for(int i=0;i<24;i++){
            DeClDailyDynamicsDTO  deClDailyDynamicsDTO = new DeClDailyDynamicsDTO();
            if(i<10) {
                deClDailyDynamicsDTO.setHour("0"+i);
            }else{
                deClDailyDynamicsDTO.setHour(i+"");
            }
            deClDailyDynamicsDTO.setGopTimes("");
            deClDailyDynamicsDTO.setErTimes("");
            myList.add(deClDailyDynamicsDTO);
        }
        //根据数据库数据更改初始化的数据
        for(int j = 0 ; j < list.size() ; j++) {
            int  hour = Integer.parseInt(list.get(j).getHour());
            myList.get(hour).setErTimes(list.get(j).getErTimes());
            myList.get(hour).setGopTimes(list.get(j).getGopTimes());
        }

        return myList;
    }

    /**
     * 测试用
     * @return
     */
    public List<DeClWaitingQueueDTO> createWaitQueue() {
        List<DeClWaitingQueueDTO> myList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            DeClWaitingQueueDTO deClWaitingQueueDTO = new DeClWaitingQueueDTO();
            deClWaitingQueueDTO.setRowNo(1);
            deClWaitingQueueDTO.setQueueId("00"+i);
            deClWaitingQueueDTO.setRecipeId("100"+i);
            deClWaitingQueueDTO.setName("李"+i);
            deClWaitingQueueDTO.setWinCode("000"+i);
            deClWaitingQueueDTO.setWinName(i+"号窗口");
            myList.add(deClWaitingQueueDTO);

        }
        return myList;
    }
}
