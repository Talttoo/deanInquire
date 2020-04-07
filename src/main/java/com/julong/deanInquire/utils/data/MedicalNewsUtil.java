package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnFiveListModel;
import com.julong.deanInquire.dto.entity.mn.MnPaDisForChartDTO;
import com.julong.deanInquire.dto.entity.mn.MnPatientsDistributionDTO;
import com.julong.deanInquire.dto.entity.mn.NewMnPatientsDistributionDTO;
import com.julong.deanInquire.dto.entity.mn.TotalTimesDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MedicalNewsUtil {

    public String getPatientsDistributionForChart(List<MnPatientsDistributionDTO> list){

        List<String> deptList = new ArrayList<>();
        List<Integer> dataList  = new ArrayList<>();
        List<MnPaDisForChartDTO> pieChartList = new ArrayList<>();
        List<NewMnPatientsDistributionDTO> newMnPatientsDistributionDTOList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.00");
        int totalTimes = 0;

        for(int i=0;i<list.size();i++){
            deptList.add(list.get(i).getDeptName());
            dataList.add(list.get(i).getInTimes());
            totalTimes+= list.get(i).getInTimes();
        }

        for (int j=0;j<list.size();j++){
            NewMnPatientsDistributionDTO  newMnPatientsDistributionDTO = new NewMnPatientsDistributionDTO();
            MnPaDisForChartDTO mnPaDisForChartDTO = new MnPaDisForChartDTO();

            mnPaDisForChartDTO.setName(list.get(j).getDeptName());
            mnPaDisForChartDTO.setData(list.get(j).getInTimes());

            newMnPatientsDistributionDTO.setDeptCode(list.get(j).getDeptCode());
            newMnPatientsDistributionDTO.setDeptName(list.get(j).getDeptName());
            newMnPatientsDistributionDTO.setInTimes(list.get(j).getInTimes());

            if (totalTimes!=0&&list.get(j).getInTimes()!=0){
                newMnPatientsDistributionDTO.setProportion(df.format((list.get(j).getInTimes()/totalTimes)*100)+"%");
            }else {
                newMnPatientsDistributionDTO.setProportion("0%");
            }

            pieChartList.add(mnPaDisForChartDTO);

            newMnPatientsDistributionDTOList.add(newMnPatientsDistributionDTO);

        }
        //科室总合计
        TotalTimesDTO totalTimesDTO = new TotalTimesDTO();
        totalTimesDTO.setTotalTimes(totalTimes);


        ReturnFiveListModel returnFiveListModel = new ReturnFiveListModel();

        String str1 = JSON.toJSONString(deptList);
        String str2 = JSON.toJSONString(dataList);
        String str3 = JSON.toJSONString(newMnPatientsDistributionDTOList);
        String str4 = JSON.toJSONString(pieChartList);

        //住院人数合计
        String str5 = JSON.toJSONString(totalTimesDTO);

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
}
