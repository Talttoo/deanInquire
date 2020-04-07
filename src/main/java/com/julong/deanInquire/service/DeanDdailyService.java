package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.entity.dean.DeAllStaffBusinessDTO;
import com.julong.deanInquire.dto.entity.dean.DeClDailyDynamicsDTO;
import com.julong.deanInquire.dto.entity.dean.DeClWaitingQueueDTO;
import com.julong.deanInquire.mapper.DeanDailyMapper;
import com.julong.deanInquire.utils.data.DeanDdailyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeanDdailyService {
    @Autowired
    DeanDailyMapper deanDailyMapper;

    @Autowired
    DeanDdailyUtil deanDdailyUtil ;

    /**
     * 当天全体业务动态
     * @return
     */
    public String getAllStaffBusiness(){

        // 返回的参数
        DeAllStaffBusinessDTO deAllStaffBusinessDTO = new DeAllStaffBusinessDTO();
        //查询数据
        deAllStaffBusinessDTO = deanDailyMapper.getAllStaffBusiness();

        // 返回前端
        String restr = deanDdailyUtil.getAllStaffBusiness(deAllStaffBusinessDTO);

       // System.out.println(restr);

        return restr;
    }


    /**
     * 门诊每日动态
     * @return
     */

    public String getClDailyDynamic(String regDate){

        // 返回的参数
        List<DeClDailyDynamicsDTO> deClDailyDynamicsDTOS =  deanDailyMapper.getClDailyDynamics(regDate);

        String str = deanDdailyUtil.getClDailyDynamicData(deClDailyDynamicsDTOS);


        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();


        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONObject jsonObject = JSONObject.parseObject(str);
        //JSONArray jsonArray= JSONArray.parseArray(str);


        // 传入模型
        returnParameterModel.setData(jsonObject);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);

        return restr;

    }

    /**
     * 门诊等候队列
     * @return
     */

    public String getClWaitingQueue(){

        List<DeClWaitingQueueDTO> deClWaitingQueueDTOS =  deanDailyMapper.getClWaitingQueue();
        //测试数据
//        if(deClWaitingQueueDTOS.size()<=0){
//            deClWaitingQueueDTOS = deanDdailyUtil.createWaitQueue()
//            ;
//        }

        String str1=JSON.toJSONString(deClWaitingQueueDTOS);

        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();


        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        //JSONObject jsonObject = JSONObject.parseObject(str1);
        // 传入模型.
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);

        return restr;

    }


}
