package com.julong.deanInquire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.ReturnModel.page.ReturnDataByPageModel;
import com.julong.deanInquire.dto.entity.mt.MtDeptMedicalWorkDTO;
import com.julong.deanInquire.dto.entity.mt.MtMedicalDetailsWorkDTO;
import com.julong.deanInquire.mapper.MtInformationMapper;
import com.julong.deanInquire.utils.data.MedicalTechUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * 医技信息
 */
@Service
public class MedicalTechService {
    @Autowired
    MtInformationMapper mtInformationMapper;

    @Autowired
    MedicalTechUtil medicalTechUtil;
    /**
     * 科室医技工作量
     * @param startTime
     * @param endTime
     * @return
     * ,int pageCount,int pageSize
     */
    public String getDeptMedicalWork( String startTime, String endTime){
        //保留两位有效小数
        DecimalFormat df = new DecimalFormat("#.00");
        //全院
        List<MtDeptMedicalWorkDTO> allList =  mtInformationMapper.getDeptMedicalWork( startTime,  endTime);

//        //门诊
//        Page<MtMedicalDetailsWorkDTO> clPage = PageHelper.startPage(pageCount, pageSize);
//        List<MtDeptMedicalWorkDTO> clList =  mtInformationMapper.getClMedicalWork( startTime,  endTime);
//
//        //住院
//        Page<MtMedicalDetailsWorkDTO> IpPage = PageHelper.startPage(pageCount, pageSize);
//        List<MtDeptMedicalWorkDTO>IpList =  mtInformationMapper.getClMedicalWork( startTime,  endTime);


//        String clStr = "";
//        String IpStr = "";
//        //根据页数分情况处理
//
//        //门诊
//        if(clPage.getPages()>1){
//            clStr = medicalTechUtil.getDeptMedicalWorkMutPage(clList);
//        }else{
//            clStr = medicalTechUtil.getDeptMedicalWorkOnePage(clList);
//        }
//
//        //住院
//        if(IpPage.getPages()>1){
//            IpStr = medicalTechUtil.getDeptMedicalWorkMutPage(IpList);
//        }else{
//            IpStr = medicalTechUtil.getDeptMedicalWorkOnePage(IpList);
//        }

        String allStr = medicalTechUtil.getDeptMedicalWork(allList);



        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        //JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONObject jsonObject = JSONObject.parseObject(allStr);
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
     * 医技明细工作量
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
    public String getMedicalDetailsWork (String startTime, String endTime,int dept,int type,int pageCount,int pageSize){

        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<MtMedicalDetailsWorkDTO> page = PageHelper.startPage(pageCount, pageSize);
        List<MtMedicalDetailsWorkDTO> mtMedicalDetailsWorkDTOList = mtInformationMapper.getMedicalDetailsWork( startTime,  endTime, dept, type);
        String str1= JSON.toJSONString(mtMedicalDetailsWorkDTOList);

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
