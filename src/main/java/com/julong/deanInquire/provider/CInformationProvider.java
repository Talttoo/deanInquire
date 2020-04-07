package com.julong.deanInquire.provider;

import com.julong.deanInquire.dto.inpram.cl.BigPrescriptionQueryPramBean;
import com.julong.deanInquire.dto.inpram.cl.DrugConsumptionPramBean;
import com.julong.deanInquire.dto.inpram.cl.DrugStatisticsPramBean;

import java.util.Objects;

/**
 * 门诊处方消耗趋势分析
 */
public class CInformationProvider {

    /**
     * 门诊业务状况分析
     * @param starTime
     * @param endTime
     * @return
     */
    public String selectBusinessConditionPartner(String starTime,String endTime){
        String  sql = "select dept ,\n" +
                "\t(select deptCode  from OM_DEPARTMENT  where OM_DEPARTMENT.deptID = dept ) as deptCode,\n" +
                "\t(select deptName  from OM_DEPARTMENT  where OM_DEPARTMENT.deptID = dept ) as deptName,\n" +
                "\tsum(clTimes) as clTimes, \n" +
                "\tsum(xyFee) as xyFee, \n" +
                "\tsum(zyFee) as zyFee,\n" +
                "\tsum(ylFee) as ylFee,\n" +
                "\tsum(totalFee) as totalFee ,  \n" +
                "\tsum(xyMaxAmount) as xyMaxAmount, \n" +
                "\tsum(zyMaxAmount) as zyMaxAmount,\n" +
                "\tsum(ylMaxAmount) as ylMaxAmount, \n" +
                "\tsum(xyTimes) as xyTimes,\n" +
                "\tsum(zyTimes) as zyTimes, \n" +
                "\tsum(ylTimes) as ylTimes\n" +
                "from (\n" +
                "\tselect a.deptID as dept,\n" +
                "\t\tcount(DISTINCT  encounterID)  as clTimes,\n" +
                "\t\t0 as xyFee , 0 as zyFee ,0 as ylFee ,0 as totalFee ,0 as xyMaxAmount,0 as zyMaxAmount, 0 as ylMaxAmount, 0 as xyTimes, 0 as zyTimes, 0 as ylTimes\n" +
                "\tfrom pc_cl_data_Recipe a \n" +
                "\twhere a.isCharge = '1' and \n" +
                "\t\ta.chargeTime >= to_date('" +
                starTime+
                "' , 'yyyy-MM-dd') and \n" +
                "\t\ta.chargeTime < to_date('" +
                endTime+
                "', 'yyyy-MM-dd')  and\n" +
                "\t\ta.recipeType <> '9'\n" +
                "\tgroup by a.deptID\n" +
                "\tunion \n" +
                "\tselect a.deptID ,\n" +
                "\t\t 0 ,\n" +
                "\t\tsum(case when  b.entryType in (3,4)then b.amount else 0 end) as xyFee,\n" +
                "\t\tsum(case when  b.entryType = 5  then b.amount else 0 end) as zyFee ,\n" +
                "\t\tsum(case when  b.entryType not in(3,4,5) then b.amount else 0 end) as ylFee ,\n" +
                "\t\tsum(b.amount) as totalFee ,\n" +
                "\t\t0,0,0,0,0,0\n" +
                "\tfrom pc_cl_data_Recipe a , pc_cl_data_RecipeEntry b\n" +
                "\twhere a.recipeID = b.recipeID \t\n" +
                "\t\tand a.isDelete = '0'\n" +
                "\t\tand a.chargeTime >= to_date('" +
                starTime+
                "' , 'yyyy-MM-dd')\n" +
                "\t\tand a.chargeTime < to_date('" +
                endTime+
                "' , 'yyyy-MM-dd')\n" +
                "\t\tand a.isCharge = '1'\n" +
                "\t\tand b.isCharge = '1'\n" +
                "\t\tand a.recipeType <> '9'\n" +
                "\t\tand a.docID is not null\n" +
                "\tgroup by a.DEPTID\n" +
                "\tunion \n" +
                "\tselect \n" +
                "\t\tDEPTID ,\n" +
                "\t\t0,0,0,0,0,\n" +
                "\t\tmax(case when  CATANAME like '%西%药%' or CATANAME like '%成%药%' then amount else 0 end ) as xyMaxAmount,\n" +
                "\t\tmax(case when  CATANAME like '%草%药%' or CATANAME like '%中药%'  then amount else 0 end) as zyMaxAmount ,\n" +
                "\t\tmax(case when (CATANAME not like '%西%药%') and (CATANAME not like '%成%药%') and (CATANAME not like '%中药%') and (CATANAME not like '%草%药%')  then amount else 0 end) as ylMaxAmount ,\n" +
                "\t\t0,0,0\n" +
                "\tfrom (\n" +
                "\t\tselect  a.DEPTID,\n" +
                "\t\t\t(select cataName from PC_RECIPECATALOG where cataID = a.cataID) as cataName ,\n" +
                "\t\t\t(select sum(amount) from pc_cl_data_recipeentry where recipeid = a.recipeid) as amount\n" +
                "\t\t from pc_cl_data_recipe a \n" +
                "\t\twhere a.chargeTime >= to_date('" +
                starTime+
                "' , 'yyyy-MM-dd') and \n" +
                "\t\t\ta.chargeTime < to_date('" +
                endTime+
                "' , 'yyyy-MM-dd') and\n" +
                "\t\t\ta.isDelete = '0' and \n" +
                "\t\t\ta.ischarge = '1' and \n" +
                "\t\t\ta.recipeType <> 9\n" +
                "\t) a \n" +
                "\tgroup by deptid\n" +
                "\tunion\n" +
                "\tselect a.deptID ,\n" +
                "\t\t0,0,0,0,0,0,0,0,\n" +
                "\t\tsum(case when  b.CATANAME like '%西%药%'  or CATANAME like '%成%药%' then 1 else 0 end) as xyTimes,\n" +
                "\t\tsum(case when  b.CATANAME like '%中药%' or b.CATANAME like '%草%药%'  then 1 else 0 end) as zyTimes ,\n" +
                "\t\tsum(case when (b.CATANAME not like '%西%药%') and (CATANAME not like '%成%药%') and (b.CATANAME not like '%中药%') and (b.CATANAME not like '%草%药%')  then 1 else 0 end) as ylTimes \n" +
                "\tfrom pc_cl_data_Recipe a , PC_RECIPECATALOG b \n" +
                "\twhere a.isCharge = '1' and \n" +
                "\t\ta.chargeTime >= to_date('" +
                starTime+
                "' , 'yyyy-MM-dd') and \n" +
                "\t\ta.chargeTime < to_date('" +
                endTime+
                "' , 'yyyy-MM-dd') and\n" +
                "\t\ta.recipeType <> '9' and \n" +
                "\t\ta.CATAID = b.CATAID\n" +
                "\tgroup by a.deptID\n" +
                ")\n" +
                "group by dept\n" +
                "order by deptCode\n";

        return sql;
    }


    /**
     * 大处方查询SQL封装类
     * @param pramDTO
     * @return
     */
    public String selectBigPrescriptionPartner(BigPrescriptionQueryPramBean pramDTO){
        StringBuilder sql = new StringBuilder();
        String startTime = pramDTO.getStartTime();
        String endTime = pramDTO.getEndTIme();
        String deptId = pramDTO.getDeptId();
        String doctorId = pramDTO.getDoctorId();
        String cataId = pramDTO.getCataId();
        String  amount = String.valueOf(pramDTO.getAmount());

        sql.append("select RECIPEID , cataName , NAME , deptCode , deptName , doctorCode , doctorName , INPUTTIME , amount " +
                " from " +
                "( select     a.RECIPEID ," +
                "(select cataName from PC_RECIPECATALOG where cataID = a.cataID) as cataName ," +
                "a.NAME, " +
                "(select deptcode from OM_DEPARTMENT where deptid = a.deptid) as deptCode ," +
                "(select deptname from OM_DEPARTMENT where deptid = a.deptid) as deptName ," +
                "(select usercode from sm_user where userid = a.docid) as doctorCode ," +
                "(select username from sm_user where userid = a.docid) as doctorName ," +
                "TO_CHAR(a.INPUTTIME, 'YYYY-MM-DD ') as INPUTTIME," +
                "(select sum(amount) from pc_cl_data_recipeentry where recipeid = a.recipeid) as amount" +
                " from pc_cl_data_recipe a  " +
                "where ");
        if(!Objects.isNull(startTime) && !"".equals(startTime)){
            sql.append(" a.INPUTTIME ").append(">=").append("to_date('"+startTime+"' ,'yyyy-MM-dd')  ");
        }
        if(!Objects.isNull(endTime) && !"".equals(endTime)){
            sql.append("and  a.INPUTTIME ").append("<").append("to_date('"+endTime+" ','yyyy-MM-dd')  ");
        }
        sql.append("and a.isDelete = '0' " +
                "and a.ischarge = '1' " +
                " and a.recipeType <> 9 " );

        if(!Objects.isNull(deptId) && !"".equals(deptId)){
            sql.append(" and  a.deptid ").append("=").append(deptId);
        }
        if(!Objects.isNull(doctorId) && !"".equals(doctorId)){
            sql.append(" and a.docid ").append("=").append(doctorId);
        }
        if(!Objects.isNull(cataId) && !"".equals(cataId)){
            sql.append(" and a.cataid ").append("=").append(cataId+" ");
        }
        if(!Objects.isNull(amount) && !"".equals(amount)){
            sql.append(")  where amount is not null and amount").append(">=").append(amount+" ");
        }

       // System.out.println(sql);
        return String.valueOf(sql);



    }

    /**
     * 门诊处方消耗趋势分析
     * @param drugConsumptionPramDTO
     * @return
     */
    public String selectDrugConsumptionPartner(DrugConsumptionPramBean drugConsumptionPramDTO){
        String sql = "";
        String startTime = drugConsumptionPramDTO.getStartTime();
        String endTime = drugConsumptionPramDTO.getEndTIme();
        String itemId = drugConsumptionPramDTO.getItemId();

        sql = "select   \n" +
                "\t(select itemcode from AB_ORDERITEM where AB_ORDERITEM.itemid = a1.itemid) as itemcode,\n" +
                "\t(select itemname from AB_ORDERITEM where AB_ORDERITEM.itemid = a1.itemid) as itemname,\n" +
                "\t(select STANDARD from AB_ORDERITEM where AB_ORDERITEM.itemid = a1.itemid) as STANDARD,\n" +
                "\t(select MA_UNIT.UNITNAME from AB_ORDERITEM , MA_UNIT where MA_UNIT.UNITID = AB_ORDERITEM.CLUNITID and AB_ORDERITEM.ITEMID = a1.itemid) as UNITNAME, \n" +
                "\tquantity,\n" +
                "\tamount,\n" +
                "\tchargetime\n" +
                "from \n" +
                "(\n" +
                "select c.ITEMID as itemid ,\n" +
                "\tsum(c.total) as quantity ,\n" +
                "\tsum(c.amount) as amount , \n" +
                "\tto_char(b.chargetime , 'yyyy-MM-dd') as chargetime\n" +
                "from  pc_cl_data_recipe b , pc_cl_data_recipeentry c \n" +
                "where \n" +
                "\tb.chargetime >= to_date( '" +
                startTime+
                "' , 'yyyy-MM-dd') and\n" +
                "\tb.chargetime < to_date( '" +
                endTime+
                "' , 'yyyy-MM-dd') and \n" +
                "\tb.recipeid = c.recipeid and \n" +
                "\tc.itemid = '" +
                itemId+
                "'\n" +
                "group by  c.itemid , to_char(b.chargetime , 'yyyy-MM-dd') \n" +
                ") a1\n" +
                "order by chargetime\n";
       // System.out.println(sql);

        return sql;
    }

    /**
     * 门诊药品统计
     * @param drugStatisticsPramBean
     * @return
     */
    public String selectDrugStatisticsPartner(DrugStatisticsPramBean drugStatisticsPramBean){

        StringBuilder sql = new StringBuilder();
        String startTime = drugStatisticsPramBean.getStartTime();
        String endTime = drugStatisticsPramBean.getEndTIme();
        int  statisticType = drugStatisticsPramBean.getStatisticType();//统计类型
        String order = drugStatisticsPramBean.getOrder();//排序类型

        sql.append("SELECT\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\titemcode\n" +
                "\t\tFROM\n" +
                "\t\t\tAB_ORDERITEM\n" +
                "\t\tWHERE\n" +
                "\t\t\tAB_ORDERITEM.itemid = a1.itemid\n" +
                "\t) AS itemcode,\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\titemname\n" +
                "\t\tFROM\n" +
                "\t\t\tAB_ORDERITEM\n" +
                "\t\tWHERE\n" +
                "\t\t\tAB_ORDERITEM.itemid = a1.itemid\n" +
                "\t) AS itemname,\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tSTANDARD\n" +
                "\t\tFROM\n" +
                "\t\t\tAB_ORDERITEM\n" +
                "\t\tWHERE\n" +
                "\t\t\tAB_ORDERITEM.itemid = a1.itemid\n" +
                "\t) AS STANDARD,\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tMA_UNIT.UNITNAME\n" +
                "\t\tFROM\n" +
                "\t\t\tAB_ORDERITEM,\n" +
                "\t\t\tMA_UNIT\n" +
                "\t\tWHERE\n" +
                "\t\t\tMA_UNIT.UNITID = AB_ORDERITEM.CLUNITID\n" +
                "\t\tAND AB_ORDERITEM.ITEMID = a1.itemid\n" +
                "\t) AS UNITNAME,\n" +
                "\tquantity,\n" +
                "\tamount\n" +
                "FROM\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tc.ITEMID AS itemid,\n" +
                "\t\t\tSUM (c.total) AS quantity,\n" +
                "\t\t\tSUM (c.amount) AS amount\n" +
                "\t\tFROM\n" +
                "\t\t\tpc_cl_data_recipe b,\n" +
                "\t\t\tpc_cl_data_recipeentry c,\n" +
                "\t\t\tAB_ORDERITEM A\n"
                );
        //如果statisticType==1 不加入PH_DRUGITEM 表
        if(statisticType==1){
            sql.append("\t\tWHERE\n" +
                    "\t\t\tb.chargetime >= TO_DATE ( ' " +
                    startTime +
                    " ', 'yyyy-MM-dd'\n" +
                    "\t\t\t)\n" +
                    "\t\tAND b.chargetime < TO_DATE (  '" +
                    endTime +
                    " ' , 'yyyy-MM-dd'\n" +
                    "\t\t)\n" +
                    "\t\tAND b.recipeid = c.recipeid\n" +
                    "\t\tAND A .itemid = c.itemid\n" +
                    "\t\tAND A .ISDRUGITEM = '1' ");
        }else{
            sql.append(" ，PH_DRUGITEM D" +
                    "\t\tWHERE\n" +
                    "\t\t\tb.chargetime >= TO_DATE ( ' " +
                    startTime +
                    " ', 'yyyy-MM-dd'\n" +
                    "\t\t\t)\n" +
                    "\t\tAND b.chargetime < TO_DATE (  '" +
                    endTime +
                    " ' , 'yyyy-MM-dd'\n" +
                    "\t\t)\n" +
                    "\t\tAND b.recipeid = c.recipeid\n" +
                    "\t\tAND A .itemid = c.itemid\n" +
                    "\t\tAND A .ISDRUGITEM = '1' ");
        }
        if(statisticType==2){
            sql.append("\tAND A .DRUGITEMID = D .DRUGID  and  d.productType  ").append("=").append(1);
        } else if(statisticType==3){
            sql.append("\tAND A .DRUGITEMID = D .DRUGID and  d.productType  ").append("=").append(statisticType);
        }else if (statisticType==4){
            sql.append("\tAND A .DRUGITEMID = D .DRUGID and  d.isAntibacterial  ").append("=").append(" '1' ");
        }else{
            //null
        }
        sql.append(" group by  c.ITEMID   ) a1  order by ");

        if("quantity".equals(order)){
            sql.append(" quantity ").append(" desc ");
        }else{
            sql.append(" amount ").append(" desc ");
        }

       // System.out.println("sql:  "+sql);
        return String.valueOf(sql);
    }

    /**
     *  门诊量-科室分析
     * @param startTime
     * @param endTime
     * @return
     */
    public  String selectVolumeAnalysisPartner(String startTime,String endTime){
        String sql = "";
        sql ="select   count(1) as clTimes ,  " +
                " (select deptcode from OM_DEPARTMENT where deptid = a.regdept) as deptCode , " +
                " (select deptname from OM_DEPARTMENT where deptid = a.regdept) as deptName " +
                " from pa_cl_data_register a " +
                "where" +
                " a.regtime >= to_date( '"+startTime+" ' , 'yyyy-MM-dd') " +
                "and   a.regtime < to_date( '"+endTime+" ', 'yyyy-MM-dd') " +
                "and  (a.regStatus = 1 or a.regStatus = 2) " +
                "and  a.cancelTime is null " +
                "and   a.REGDEPT is not null " +
                "group by   a.regdept order by deptcode";

        return sql;
    }

    /**
     *  门诊量-性别分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectGenderAnalysisPartner(String startTime,String endTime){
        String sql = "";
        sql  =   "select \n" +
                "\t(case when a.SEX = 1 then '男' when a.SEX = 2  then '女'  else '未知的性别' end) as sex , \n" +
                "\tcount(1) as cltimes\n" +
                "  from pa_cl_data_register a\n" +
                "where a.regtime >= to_date( '"+startTime+" ' , 'yyyy-MM-dd') and \n" +
                "\ta.regtime < to_date('"+endTime+" ' , 'yyyy-MM-dd') and\n" +
                "\t(a.regStatus = 1 or a.regStatus = 2) and\n" +
                "\ta.cancelTime is null \n" +
                "group by \n" +
                "\t(case when a.SEX = 1 then '男' when a.SEX = 2  then '女'  else '未知的性别' end) \n" +
                "order by sex\n";
        return  sql;
    }

    /**
     *  门诊量 -日期分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectDateAnalysisPartner(String startTime,String endTime){
        String sql  = "";
        sql = "select \n" +
                "\tcount(1) as clTimes , \n" +
                "\tto_char(a.regtime , 'yyyy-MM-dd') as regdate \n" +
                "from pa_cl_data_register a\n" +
                "where a.regtime >= to_date( '"+startTime+"' , 'yyyy-MM-dd') and \n" +
                "\ta.regtime < to_date('"+endTime+"' , 'yyyy-MM-dd') and\n" +
                "\t(a.regStatus = 1 or a.regStatus = 2) and\n" +
                "\ta.cancelTime is null and \n" +
                "\ta.REGDEPT is not null\n" +
                "group by \n" +
                "\tto_char(a.regtime , 'yyyy-MM-dd') \n" +
                "order by regdate ";
        return sql;
    }
}
