package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.julong.deanInquire.dto.ReturnModel.page.ReturnDataByPageModel;
import com.julong.deanInquire.dto.entity.ds.DsDiseaseAgeDTO;
import com.julong.deanInquire.dto.entity.ds.DsDiseaseAmountDTO;
import com.julong.deanInquire.dto.entity.ds.New_DsDiseaseAmountDTO;
import com.julong.deanInquire.mapper.DiseaseAnalysisMapper;
import com.julong.deanInquire.utils.data.DiseaseAnalysisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseAnalysisService {

    @Autowired
    DiseaseAnalysisMapper diseaseAnalysisMapper;

    /**
     *  1）	疾病年龄段分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String getDiseaseAge(String startTime, String endTime,int pageCount,int pageSize){

        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<DsDiseaseAgeDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<DsDiseaseAgeDTO> dsDiseaseAgeDTOS = diseaseAnalysisMapper.getDiseaseAge( startTime,  endTime);
       // System.out.println("总条数："+page.getTotal());
        //System.out.println("总页数："+page.getPages());

        String str1= JSON.toJSONString(dsDiseaseAgeDTOS);


        // 创建实例
        ReturnDataByPageModel returnDataByPageModel = new ReturnDataByPageModel();


        // 返回code
        returnDataByPageModel.setStatusCode(200);
        //总页数
        returnDataByPageModel.setTotalPage(page.getPages());
        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        //JSONObject jsonObject = JSONObject.parseObject(str1);
        // 传入模型.
        returnDataByPageModel.setData(jsonArray);

        // 返回errMsg
        returnDataByPageModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnDataByPageModel);
        //System.out.println(restr);

        return restr;

    }

    /**
     * 疾病金额人次分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String getDiseaseAmount(String startTime, String endTime,int pageCount,int pageSize){
        int totalPage = 0;

        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<DsDiseaseAmountDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<DsDiseaseAmountDTO> dsDiseaseAmountDTOS = diseaseAnalysisMapper.getDiseaseAmount( startTime,  endTime);
        //System.out.println("总条数："+page.getTotal());
       //System.out.println("总页数："+page.getPages());


        DiseaseAnalysisUtil util = new DiseaseAnalysisUtil();
        //计算平均金额
        List <New_DsDiseaseAmountDTO> list = util.getDiseaseAmount(dsDiseaseAmountDTOS);

        String str1= JSON.toJSONString(list);

        // 创建实例
      ReturnDataByPageModel returnDataByPageModel = new ReturnDataByPageModel();

        // 返回code
        returnDataByPageModel.setStatusCode(200);

        returnDataByPageModel.setTotalPage(page.getPages());

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        //JSONObject jsonObject = JSONObject.parseObject(str1);
        // 传入模型.
        returnDataByPageModel.setData(jsonArray);

        // 返回errMsg
        returnDataByPageModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnDataByPageModel);
        //System.out.println(restr);

        return restr;

    }
}
