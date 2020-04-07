package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.item.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 公共mapper
 */
public interface UtilsMapper {

    /*
     * 查找科室
     * */
    @Select( "select DISTINCT "+
            "a.DEPTID ,"+
            "a.DEPTCODE ,"+
            "a.DEPTNAME  "+
            "FROM  OM_DEPARTMENT a ,"+
            "OM_DEPARTMENTVISIT b "+
            "where a.DEPTID = b.DEPTID and "+
            "a.ISDELETE = '0' and "+
            "(b.VISITTYPE = 1 or b.VISITTYPE = 2) "+
            "order by a.DEPTCODE ")
    public List<DepartmentDTO> findDept();

    /**
     * 查找医生
     * @return
     */
    @Select("select a.USERID ,\n" +
            "\t a.USERCODE , \n" +
            "\t a.USERNAME \n" +
            "from SM_USER a  , \n" +
            "\tSM_USERINFO b ,\n" +
            "\t(select DISTINCT  c.USERID\n" +
            "\t\tfrom OM_DEPARTMENT a , OM_DEPARTMENTVISIT b , SM_USERLOC c \n" +
            "\t\twhere a.DEPTID = b.DEPTID and\n" +
            "\t\t\ta.DEPTID = c.LOCID and \n" +
            "\t\t\ta.ISDELETE = '0' and \n" +
            "\t\t\t(b.VISITTYPE = 1 or b.VISITTYPE = 2)\n" +
            "\t) c\n" +
            "where a.USERID = b.USERID and \n" +
            "\ta.USERID = c.USERID and \n" +
            "\ta.ISDELETE = '0' and \n" +
            "\tb.userTypeID = 1\n" +
            "order by a.USERCODE\n")
    public List<DoctorDTO> getDoctor();

    /**
     * 选择处方类型分类
     */
    @Select("select \n" +
            "    CATAID,\n" +
            "    CATACODE,\n" +
            "    CATANAME\n" +
            "from PC_RECIPECATALOG\n" +
            "where ISDELETE = '0'\n" +
            "order by CATACODE\n")
    public List<PrescriptionClassificationDTO> getPrescriptionClassification();

    /**
     * 选择药品分类
     * @return
     */
    @Select("select itemid , itemcode , itemname \n" +
            "from AB_ORDERITEM a\n" +
            "where a.ISDRUGITEM = '1' and\n" +
            "\ta.ISCLITEM = '1' and\n" +
            "\ta.ISDELETE = '0'\n" +
            "order by a.ITEMCODE\n")
    public List<DrugClassificationDTO> getDrugClassification();

    /**
     * 选择药品
     * @return
     */
    @Select("select b.STUFFID , b.STUFFCODE , b.STUFFCODE || ' — ' || b.stuffname  as  stuffname\n" +
            "from MA_STUFFLOCATION a ,  MA_STUFFITEM b\n" +
            "where a.STUFFID = b.STUFFID and\n" +
            "\tb.ISDELETE = '0' and\n" +
            "\ta.LOCID = #{locId}\n" +
            "order by STUFFCODE\n")
    public List<DrugDTO> getDrug(String locId);

    /**
     * 选择药房
     * @return
     */
    @Select("select DISTINCT\n" +
            "\ta.DEPTID ,\n" +
            "\ta.DEPTCODE , \n" +
            "\ta.DEPTNAME\n" +
            "from OM_DEPARTMENT a\n" +
            "where \n" +
            "\ta.ISDELETE = '0' and \n" +
            "\t(a.deptType = 9 or a.deptType = 8) and \n" +
            "\ta.isManageDrugStorage = '1'\n" +
            "order by a.DEPTCODE\n")
    public List<DepartmentDTO> getDrugDept();


    /**
     * 选择门诊药房
     * @return
     */
    @Select("select DISTINCT\n" +
            "\ta.DEPTID ,\n" +
            "\ta.DEPTCODE , \n" +
            "\ta.DEPTNAME\n" +
            "from OM_DEPARTMENT a\n" +
            "where \n" +
            "\ta.ISDELETE = '0' and \n" +
            "\ta.deptType = 9 and \n" +
            "\ta.isManageDrugStorage = '1'\n" +
            "order by a.DEPTCODE")
    public List<DepartmentDTO> getClDrugDept();

}
