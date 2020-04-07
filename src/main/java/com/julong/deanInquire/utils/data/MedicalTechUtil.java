package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnThreeListModel;
import com.julong.deanInquire.dto.entity.mt.MtDeptMedicalWorkDTO;
import com.julong.deanInquire.dto.entity.mt.NewMtDeptMedicalWorkDTO;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
@Component
public class MedicalTechUtil {
    //保留两位有效小数
    DecimalFormat df = new DecimalFormat("#.00");
    /**
     * 全院数据处理方法
     * @param list
     * @return
     */
    public String getDeptMedicalWork(List<MtDeptMedicalWorkDTO> list){

        List<NewMtDeptMedicalWorkDTO> clList = new ArrayList<>();
        List<NewMtDeptMedicalWorkDTO> ipList = new ArrayList<>();

        int sumAlljcTimes=0,sumAllhyTimes=0,
                sumCljcTimes=0,sumClhyTimes=0,
                sumIpjcTimes=0,sumIphyTimes=0;
        double sumAlljcAmount=0,sumAllhyAmount=0,sumAlljcAvg=0,sumAllhyAvg=0 ,
                sumCljcAmount=0,sumClhyAmount=0,sumCljcAvg=0,sumClhyAvg=0,
                sumIpjcAmount=0,sumIphyAmount=0,sumIpjcAvg=0,sumIphyAvg=0;

        for(int i=0;i<list.size();i++){
            if("门诊".equals(list.get(i).getIpclType())||list.get(i).getIpclType()=="门诊"){
                NewMtDeptMedicalWorkDTO  newMtDeptMedicalWorkDTO = new  NewMtDeptMedicalWorkDTO();
                newMtDeptMedicalWorkDTO.setIpclType(list.get(i).getIpclType());
                newMtDeptMedicalWorkDTO.setDeptId(list.get(i).getDeptId());
                newMtDeptMedicalWorkDTO.setDeptCode(list.get(i).getDeptCode());
                newMtDeptMedicalWorkDTO.setDeptName(list.get(i).getDeptName());
                newMtDeptMedicalWorkDTO.setHyAmount(list.get(i).getHyAmount());
                newMtDeptMedicalWorkDTO.setJcAmount(list.get(i).getJcAmount());
                newMtDeptMedicalWorkDTO.setHyTimes(list.get(i).getHyTimes());
                newMtDeptMedicalWorkDTO.setJcTimes(list.get(i).getJcTimes());
                if(list.get(i).getHyTimes()>0){
                    newMtDeptMedicalWorkDTO.setHyAvgAmount(Double.parseDouble(df.format(list.get(i).getHyAmount()/list.get(i).getHyTimes())));
                }else {
                    newMtDeptMedicalWorkDTO.setHyAvgAmount(0.0);
                }

                if(list.get(i).getJcTimes()>0){
                    newMtDeptMedicalWorkDTO.setJcAvgAmount(Double.parseDouble(df.format(list.get(i).getJcAmount()/list.get(i).getJcTimes())));
                }else {
                    newMtDeptMedicalWorkDTO.setJcAvgAmount(0.0);
                }

                //门诊科室小计
                sumCljcTimes+=list.get(i).getJcTimes();
                sumClhyTimes+=list.get(i).getHyTimes();
                sumCljcAmount+=list.get(i).getJcAmount();
                sumClhyAmount+=list.get(i).getHyAmount();

                //sumCljcAvg=0,sumClhyAvg=0;

                clList.add(newMtDeptMedicalWorkDTO);

            }else{

                NewMtDeptMedicalWorkDTO  newMtDeptMedicalWorkDTO = new  NewMtDeptMedicalWorkDTO();
                newMtDeptMedicalWorkDTO.setIpclType(list.get(i).getIpclType());
                newMtDeptMedicalWorkDTO.setDeptId(list.get(i).getDeptId());
                newMtDeptMedicalWorkDTO.setDeptCode(list.get(i).getDeptCode());
                newMtDeptMedicalWorkDTO.setDeptName(list.get(i).getDeptName());
                newMtDeptMedicalWorkDTO.setHyAmount(list.get(i).getHyAmount());
                newMtDeptMedicalWorkDTO.setJcAmount(list.get(i).getJcAmount());
                newMtDeptMedicalWorkDTO.setHyTimes(list.get(i).getHyTimes());
                newMtDeptMedicalWorkDTO.setJcTimes(list.get(i).getJcTimes());
                if(list.get(i).getHyTimes()>0){
                    newMtDeptMedicalWorkDTO.setHyAvgAmount(Double.parseDouble(df.format(list.get(i).getHyAmount()/list.get(i).getHyTimes())));
                }else {
                    newMtDeptMedicalWorkDTO.setHyAvgAmount(0);
                }

                if(list.get(i).getJcTimes()>0){
                    newMtDeptMedicalWorkDTO.setJcAvgAmount(Double.parseDouble(df.format(list.get(i).getJcAmount()/list.get(i).getJcTimes())));
                }else {
                    newMtDeptMedicalWorkDTO.setJcAvgAmount(0);
                }

                //住院科室小计
                sumIpjcTimes+=list.get(i).getJcTimes();
                sumIphyTimes+=list.get(i).getHyTimes();
                sumIpjcAmount+=list.get(i).getJcAmount();
                sumIphyAmount+=list.get(i).getHyAmount();

                //sumIpjcAvg=0,sumIphyAvg=0;

                ipList.add(newMtDeptMedicalWorkDTO);

            }
        }


        //门诊科室小计

        NewMtDeptMedicalWorkDTO  clDTO = new  NewMtDeptMedicalWorkDTO();
        clDTO.setIpclType("门诊");
//        clDTO.setDeptId());
//        clDTO.setDeptCode();
        clDTO.setDeptName("科室小计");
        clDTO.setHyAmount(sumClhyAmount);
        clDTO.setJcAmount(sumCljcAmount);
        clDTO.setHyTimes(sumClhyTimes);
        clDTO.setJcTimes(sumCljcTimes);
        if(sumClhyAmount!=0&&sumClhyTimes!=0){
            clDTO.setJcAvgAmount(Double.parseDouble(df.format(sumClhyAmount/sumClhyTimes)));
        }else{
            clDTO.setJcAvgAmount(0.00);
        }
        if(sumCljcAmount!=0&&sumCljcTimes!=0){
            clDTO.setHyAvgAmount(Double.parseDouble(df.format(sumCljcAmount/sumCljcTimes)));
        }else{
            clDTO.setHyAvgAmount(0.00);
        }


        clList.add(clDTO);

//        double sumAlljcTimes=0,sumAllhyTimes=0,sumAlljcAmount=0,sumAllhyAmount=0,sumAlljcAvg=0,sumAllhyAvg=0;
//        double sumCljcTimes=0,sumClhyTimes=0,sumCljcAmount=0,sumClhyAmount=0,sumCljcAvg=0,sumClhyAvg=0;
//        double sumIpjcTimes=0,sumIphyTimes=0,sumIpjcAmount=0,sumIphyAmount=0,sumIpjcAvg=0,sumIphyAvg=0;

        //住院科室小计

        NewMtDeptMedicalWorkDTO  ipDTO = new  NewMtDeptMedicalWorkDTO();
        ipDTO.setIpclType("住院");

        ipDTO.setDeptName("科室小计");
        ipDTO.setHyAmount(sumIphyAmount);
        ipDTO.setJcAmount(sumIpjcAmount);
        ipDTO.setHyTimes(sumIphyTimes);
        ipDTO.setJcTimes(sumIpjcTimes);
        ipDTO.setHyAvgAmount(Double.parseDouble(df.format(sumIphyAmount/sumIphyTimes)));
        ipDTO.setJcAvgAmount(Double.parseDouble(df.format(sumIpjcAmount/sumIpjcTimes)));

        ipList.add(ipDTO);

        //全院合计
        NewMtDeptMedicalWorkDTO  AllDTO = new  NewMtDeptMedicalWorkDTO();
        AllDTO.setIpclType("合计");
        AllDTO.setHyAmount(Double.parseDouble(df.format(sumClhyAmount+sumIphyAmount)));
        AllDTO.setJcAmount(Double.parseDouble(df.format(sumCljcAmount+sumIpjcAmount)));
        AllDTO.setHyTimes(sumClhyTimes+sumIphyTimes);
        AllDTO.setJcTimes(sumCljcTimes+sumIpjcTimes);
        AllDTO.setHyAvgAmount(Double.parseDouble(df.format((sumClhyAmount+sumIphyAmount)/(sumClhyTimes+sumIphyTimes))));
        AllDTO.setJcAvgAmount(Double.parseDouble(df.format((sumCljcAmount+sumIpjcAmount)/(sumCljcTimes+sumIpjcTimes))));





        String str1= JSON.toJSONString(clList);
        String str2= JSON.toJSONString(ipList);
//        String str3= JSON.toJSONString(clDTO);
//        String str4= JSON.toJSONString(ipDTO);
        String str5= JSON.toJSONString(AllDTO);

        ReturnThreeListModel returnThreeListModel = new ReturnThreeListModel();

        JSONArray cl_jsonArray = JSON.parseArray(str1);
        JSONArray ip_jsonArray = JSON.parseArray(str2);
       // JSONObject cl_jsonObject = JSON.parseObject(str3);
       // JSONObject ip_jsonObject = JSON.parseObject(str4);
        JSONObject all_jsonObject = JSON.parseObject(str5);

        returnThreeListModel.setList1(cl_jsonArray);
        returnThreeListModel.setList2(ip_jsonArray);
        returnThreeListModel.setList3(all_jsonObject);
//        returnFiveListModel.setList4(ip_jsonObject);
//        returnFiveListModel.setList5(all_jsonObject);

        String restr = JSON.toJSONString(returnThreeListModel);
        //System.out.println(restr);
        return  restr;


    }

    /**
     * 一页数据处理方法
     * @param list
     * @return
     */
    public String getDeptMedicalWorkOnePage(List<MtDeptMedicalWorkDTO> list){
        return "";
    }

    /**
     * 多页数据处理方法
     * @param list
     * @return
     */
    public String getDeptMedicalWorkMutPage(List<MtDeptMedicalWorkDTO> list){

        return "";
    }
}
