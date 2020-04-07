package com.julong.deanInquire.controller;

import com.alibaba.fastjson.JSONArray;
import com.julong.deanInquire.dto.ReturnModel.ReturnMutiParameterModel;
import com.julong.deanInquire.dto.ReturnModel.ReturnParameterModel;
import com.julong.deanInquire.dto.entity.item.*;
import com.julong.deanInquire.mapper.UtilsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UtilsController {

    @Autowired
    UtilsMapper utilsMapper;

    /**
     * 查找科室
     * @return
     */
    //@RequestMapping( value = "/utils/dept",method = RequestMethod.POST)
    /*@ResponseBody
    @RequestMapping(value="dept",method=RequestMethod.GET,produces="application/json;charset=UTF-8")*/
    @GetMapping("/utils/dept")
    public String getDept(){
        //System.out.println("请求科室.....");
        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();
        // 返回的参数
        List<DepartmentDTO> deptList = utilsMapper.findDept();
        String str1=JSON.toJSONString(deptList);

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);

        // 传入模型
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("ok");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
        System.out.println(restr);
        return restr;

    }

    /**
     * 查找药房
     * @return
     */
    @GetMapping("/utils/drugdept")
    public String getDrugDept(){
         List<DepartmentDTO> deptList = utilsMapper.getDrugDept();
         //  System.out.println("请求科室.....");
        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();
        // 返回的参数
        String str1=JSON.toJSONString(deptList);

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);

        // 传入模型
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
        System.out.println(restr);
        return restr;

    }

    /**
     * 查找门诊药房
     * @return
     */
    @GetMapping("/utils/cldrugdept")
    public String getClDrugDept(){
        List<DepartmentDTO> deptList = utilsMapper.getClDrugDept();
        System.out.println("请求门诊药房.....");
        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();
        // 返回的参数
        String str1=JSON.toJSONString(deptList);

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);

        // 传入模型
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);
        return restr;

    }


    /**
     * 查找医生
     * @return
     */
    @GetMapping("/utils/doctor")
    public String getDoctor(){

        List<DoctorDTO> docList = utilsMapper.getDoctor();
        String str1=JSON.toJSONString(docList);

        //System.out.println(str1);

        return "";
    }

    /**
     * 查找药品
     * @return
     */
    @GetMapping("/utils/drug")
    public String getDrug(@RequestParam(name="locId")String locId){
        System.out.println("请求locId"+locId);
        List<DrugDTO> drugList = utilsMapper.getDrug(locId);
        List<NewDrugDTO> newDrugDTOList = new ArrayList<>();
        NewDrugDTO nullDrug = new NewDrugDTO();
        nullDrug.setTitle("全部项目");
        nullDrug.setValue("1");
        newDrugDTOList.add(nullDrug);
        for (int i=0;i<drugList.size();i++){
            NewDrugDTO newDrugDTO = new NewDrugDTO();
            newDrugDTO.setValue(drugList.get(i).getStuffCode());
            newDrugDTO.setTitle(drugList.get(i).getStuffName());
            newDrugDTOList.add(newDrugDTO);
        }

        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();
        // 返回的参数
        String str1=JSON.toJSONString(newDrugDTOList);

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);

        // 传入模型
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);
        return restr;

    }

    /**
     * 选择处方类型分类
     * @return
     */
    @GetMapping("/utils/prescription")
    public String getPrescriptionClassification(){
        List<PrescriptionClassificationDTO>  prescriptionClassificationList = utilsMapper.getPrescriptionClassification();
        String str1=JSON.toJSONString(prescriptionClassificationList);
        System.out.println(str1);
        return "";
    }

    /**
     * 查找药品分类
     * @return
     */
    @GetMapping("/utils/drugclass")
    public String getDrugClassification(){

        // 创建实例
        ReturnParameterModel returnParameterModel = new ReturnParameterModel();
        // 返回的参数
        List<DrugClassificationDTO> drugClassificationList = utilsMapper.getDrugClassification();

        String str1=JSON.toJSONString(drugClassificationList);

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);

        // 传入模型
        returnParameterModel.setData(jsonArray);

        // 返回errMsg
        returnParameterModel.setErrMsg("ok");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);
        return restr;
    }
    @GetMapping("/utils/cataInPram")
    public String getBigCataInPram(){
        //System.out.println("请求获取大处方参数");
        // 创建实例
        ReturnMutiParameterModel returnParameterModel = new ReturnMutiParameterModel();
        // 返回的参数
        List<PrescriptionClassificationDTO>  prescriptionClassificationList = utilsMapper.getPrescriptionClassification();

        List<DepartmentDTO> deptList = utilsMapper.findDept();

        List<DoctorDTO> docList = utilsMapper.getDoctor();

        String str1=JSON.toJSONString(prescriptionClassificationList);
        String str2=JSON.toJSONString(deptList);
        String str3=JSON.toJSONString(docList);

        // 返回code
        returnParameterModel.setStatusCode(200);

        // 转为JSONArray
        JSONArray jsonArray= JSONArray.parseArray(str1);
        JSONArray jsonArray2= JSONArray.parseArray(str2);
        JSONArray jsonArray3= JSONArray.parseArray(str3);

        // 传入模型
        returnParameterModel.setData(jsonArray);
        returnParameterModel.setData_2(jsonArray2);
        returnParameterModel.setData_3(jsonArray3);

        // 返回errMsg
        returnParameterModel.setErrMsg("success");
        // 返回前端
        String restr = JSON.toJSONString(returnParameterModel);
       // System.out.println(restr);
        return restr;



    }






}
