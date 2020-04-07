package com.julong.deanInquire.utils.data;

import com.julong.deanInquire.dto.entity.ds.DsDiseaseAmountDTO;
import com.julong.deanInquire.dto.entity.ds.New_DsDiseaseAmountDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 疾病分析数据封装工具类
 */
public class DiseaseAnalysisUtil {
    /**
     * 疾病金额人次分析-计算平均金额
     * @param list
     * @return
     */
    public List<New_DsDiseaseAmountDTO> getDiseaseAmount(List<DsDiseaseAmountDTO> list){
        List<New_DsDiseaseAmountDTO> newList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.00");
        //遍历计算平均金额
        for(int i = 0;i<list.size();i++){
            New_DsDiseaseAmountDTO obj = new New_DsDiseaseAmountDTO();
            obj.setRowNum(list.get(i).getRowNum());
            obj.setDiagName(list.get(i).getDiagName());
            obj.setTimes(list.get(i).getTimes());
            obj.setTotal(list.get(i).getTotal());
            if(list.get(i).getTimes()>0) {
                obj.setAvgAmount(Double.parseDouble(df.format(list.get(i).getTotal()/list.get(i).getTimes())));
            }else {
                obj.setAvgAmount(0.0);
            }
            newList.add(obj);
        }


        return newList;

    }
}
