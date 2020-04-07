package com.julong.deanInquire.provider;

/**
 * 医技信息
 */
public class MtInformationProvider {

    /**
     * 医技明细工作量
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
    public String selectMedicalDetailsWorkPartner(String startTime,String endTime,int dept,int type){
        String sql= "";
        //门诊
        if (dept==1){
            sql="select " +
                    " \tb.ITEMID as itemid , " +
                    "\t(select itemcode from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemcode," +
                    " \t(select itemname from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemname, " +
                    "\tsum(b.TOTAL)  as quantity, " +
                    "\tmax(b.PRICE) as price , " +
                    "\tsum(b.AMOUNT) as amount, " +
                    "\tb.entryType as type " +
                    "from pc_cl_data_recipe a , pc_cl_data_recipeentry b " +
                    "where a.RECIPEID = b.RECIPEID " +
                    "and  \tb.entryType = " +
                    type +
                    "and  \tb.isItem = '1' " +
                    "and  \ta.ISDELETE = '0' " +
                    "and  \ta.ISCHARGE = '1'" +
                    " and  \ta.CHARGETIME >= trunc(TO_DATE('" +
                    startTime+
                    "','yyyy-mm-dd'),'dd') " +
                    "and  \ta.CHARGETIME < trunc(TO_DATE ('" +
                    endTime +
                    "', 'yyyy-mm-dd'),'dd') " +
                    "and  \ttrunc(TO_DATE ('" +
                    startTime +
                    "', 'yyyy-mm-dd'),'dd') <= trunc(TO_DATE ('" +
                    endTime +
                    "', 'yyyy-mm-dd'),'dd')  " +
                    " group by b.ITEMID  , b.entryType " +
                    "order by amount desc";
        }else if(dept==2){//住院
            sql = "select   \tb.ITEMID as itemid , " +
                    "\t(select itemcode from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemcode, " +
                    "\t(select itemname from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemname, " +
                    "\tsum(a.quantity)  as quantity, " +
                    "\tmax(a.PRICE) as price , " +
                    "\tsum(a.AMOUNT) as amount, " +
                    "\tb.preType as type  " +
                    "from " +
                    "AB_IP_DATA_BILL a ,  PC_IP_DATA_PRESCRIPTION b " +
                    " where a.preid = b.PREID " +
                    "and  b.preType =" +
                    type +
                    "and  \tb.isItem = '1'" +
                    " and  \ta.billTime >= trunc(to_date('" +
                    startTime +
                    "','yyyy-mm-dd'),'dd') and  \ta.billTime < trunc(to_date('" +
                    endTime +
                    "','yyyy-mm-dd'),'dd') " +
                    "and  \ttrunc(to_date('" +
                    startTime +
                    "','yyyy-mm-dd'),'dd') <= trunc(to_date('" +
                    endTime +
                    "','yyyy-mm-dd'),'dd')" +
                    "  group by b.ITEMID  , b.preType  " +
                    "order by amount desc";
        }else{
            sql = "select a1.itemid , " +
                    "\t(select itemcode from AB_ORDERITEM where AB_ORDERITEM.itemid = a1.itemid) as itemcode, " +
                    "\t(select itemname from AB_ORDERITEM where AB_ORDERITEM.itemid = a1.itemid) as itemname, " +
                    "\tsum(a1.quantity)  as quantity, \tmax(a1.price) as price , " +
                    "\tsum(a1.amount) as amount ,  " +
                    "\ta1.type " +
                    "from " +
                    "( select  \tb.ITEMID as itemid , " +
                    "\t(select itemcode " +
                    "from AB_ORDERITEM " +
                    "where AB_ORDERITEM.itemid = b.itemid) as itemcode, " +
                    "\t(select itemname from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemname, " +
                    "\tsum(b.TOTAL)  as quantity, " +
                    "\tmax(b.PRICE) as price , " +
                    "\tsum(b.AMOUNT) as amount, " +
                    "\tb.entryType as type" +
                    " from " +
                    "pc_cl_data_recipe a , pc_cl_data_recipeentry b " +
                    " where a.RECIPEID = b.RECIPEID " +
                    "and  b.entryType = " +
                    type +
                    "and  \tb.isItem = '1' and  \ta.ISDELETE = '0' " +
                    "and  \ta.ISCHARGE = '1' and  " +
                    "\ta.CHARGETIME >= trunc(to_date('" +
                    startTime +
                    "','yyyy-mm-dd'),'dd') " +
                    "and  \ta.CHARGETIME < trunc(to_date('" +
                    endTime +
                    "','yyyy-mm-dd'),'dd')  " +
                    "group by b.ITEMID  , b.entryType \n" +
                    " union all  \n" +
                    "select   \tb.ITEMID as itemid , " +
                    "\t(select itemcode from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemcode," +
                    " \t(select itemname from AB_ORDERITEM where AB_ORDERITEM.itemid = b.itemid) as itemname," +
                    " \tsum(a.quantity)  as quantity, " +
                    "\tmax(a.PRICE) as price ," +
                    " \tsum(a.AMOUNT) as amount ,  " +
                    "\tb.preType as type " +
                    "from " +
                    "AB_IP_DATA_BILL a ,  PC_IP_DATA_PRESCRIPTION b " +
                    "where a.preid = b.PREID " +
                    "and  b.preType = " +
                    type +
                    "and  \tb.isItem = '1' " +
                    "and  \ta.billTime >= trunc(to_date('" +
                    startTime +
                    "','yyyy-mm-dd'),'dd') and  \ta.billTime < trunc(to_date('" +
                    endTime +
                    "','yyyy-mm-dd'),'dd') " +
                    " group by b.ITEMID  , b.preType  ) a1 " +
                    " group by ITEMID  , type  " +
                    "order by amount desc\n";
        }
       // System.out.println(sql);
        return sql;
    }
    /**
     * 科室医技工作量
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectDeptMedicalWorkPartner(String startTime,String endTime){
        String sql = "select\n" +
                "\tipcltype,\n" +
                "\ta1.deptid ,\n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = a1.deptid) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = a1.deptid) as deptName ,\n" +
                "\ta1.jctimes ,\n" +
                "\ta1.hytimes , \n" +
                "\ta1.jcamount ,\n" +
                "\ta1.hyamount \n" +
                "from (\n" +
                "select \n" +
                "\t'门诊' as ipcltype , \n" +
                "\ta.DEPTID as deptid, \n" +
                "\tcount(DISTINCT decode(b.entryType , 6 , b.recipeid)) as jcTimes ,\n" +
                "\tcount(DISTINCT decode(b.entryType , 7 , b.recipeid)) as hyTimes ,\n" +
                "\tsum(decode(b.entryType , 6 , b.AMOUNT)) as jcAmount,\n" +
                "\tsum(decode(b.entryType , 7 , b.AMOUNT)) as hyAmount\n" +
                "from pc_cl_data_recipe a , pc_cl_data_recipeentry b\n" +
                "where a.RECIPEID = b.RECIPEID and \n" +
                "\t(b.entryType = 6 or b.entryType = 7) and \n" +
                "\tb.isItem = '1' and \n" +
                "\ta.ISDELETE = '0' and \n" +
                "\ta.ISCHARGE = '1' and \n" +
                "\ta.CHARGETIME >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\ta.CHARGETIME < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd')\n" +
                "group by a.DEPTID\n" +
                "union all \n"+
                "select \n" +
                "\t'住院' as ipcltype , \n" +
                "\tb.orderDept as deptid , \n" +
                "\tcount(DISTINCT decode(b.preType , 6 , to_char(a.encounterID)) || to_char(a.billDate , 'yyyy.mm.dd') ) as jcTimes ,\n" +
                "\tcount(DISTINCT decode(b.preType , 7 , to_char(a.encounterID)) || to_char(a.billDate , 'yyyy.mm.dd') ) as hyTimes ,\n" +
                "\tsum(decode(b.preType , 6 , a.AMOUNT)) as jcAmount , \n" +
                "\tsum(decode(b.preType , 7 , a.AMOUNT)) as hyAmount  \n" +
                "from AB_IP_DATA_BILL a ,  PC_IP_DATA_PRESCRIPTION b\n" +
                "where a.preid = b.PREID and \n" +
                "\t(b.preType = 6 or b.preType = 7) and \n" +
                "\tb.isItem = '1' and \n" +
                "\ta.billTime >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\ta.billTime < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd')\n" +
                "group by  b.orderDept \n" +
                ") a1 \n" +
                "order by ipcltype , deptCode\n";


        return sql;
    }

    /**
     * 科室医技工作量-门诊(不用)
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectClMedicalWorkPartner(String startTime,String endTime){
        String sql = "select\n" +
                "\tipcltype,\n" +
                "\ta1.deptid ,\n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = a1.deptid) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = a1.deptid) as deptName ,\n" +
                "\ta1.jctimes ,\n" +
                "\ta1.hytimes , \n" +
                "\ta1.jcamount ,\n" +
                "\ta1.hyamount \n" +
                "from (\n" +
                "select \n" +
                "\t'门诊' as ipcltype , \n" +
                "\ta.DEPTID as deptid, \n" +
                "\tcount(DISTINCT decode(b.entryType , 6 , b.recipeid)) as jcTimes ,\n" +
                "\tcount(DISTINCT decode(b.entryType , 7 , b.recipeid)) as hyTimes ,\n" +
                "\tsum(decode(b.entryType , 6 , b.AMOUNT)) as jcAmount,\n" +
                "\tsum(decode(b.entryType , 7 , b.AMOUNT)) as hyAmount\n" +
                "from pc_cl_data_recipe a , pc_cl_data_recipeentry b\n" +
                "where a.RECIPEID = b.RECIPEID and \n" +
                "\t(b.entryType = 6 or b.entryType = 7) and \n" +
                "\tb.isItem = '1' and \n" +
                "\ta.ISDELETE = '0' and \n" +
                "\ta.ISCHARGE = '1' and \n" +
                "\ta.CHARGETIME >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\ta.CHARGETIME < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd')\n" +
                "group by a.DEPTID\n" ;


        return sql;
    }

    /**
     * 科室医技工作量-住院（不用）
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectIpMedicalWorkPartner(String startTime,String endTime){
        String sql = "select \n" +
                "\t'住院' as ipcltype , \n" +
                "\tb.orderDept as deptid , \n" +
                "\tcount(DISTINCT decode(b.preType , 6 , to_char(a.encounterID)) || to_char(a.billDate , 'yyyy.mm.dd') ) as jcTimes ,\n" +
                "\tcount(DISTINCT decode(b.preType , 7 , to_char(a.encounterID)) || to_char(a.billDate , 'yyyy.mm.dd') ) as hyTimes ,\n" +
                "\tsum(decode(b.preType , 6 , a.AMOUNT)) as jcAmount , \n" +
                "\tsum(decode(b.preType , 7 , a.AMOUNT)) as hyAmount  \n" +
                "from AB_IP_DATA_BILL a ,  PC_IP_DATA_PRESCRIPTION b\n" +
                "where a.preid = b.PREID and \n" +
                "\t(b.preType = 6 or b.preType = 7) and \n" +
                "\tb.isItem = '1' and \n" +
                "\ta.billTime >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\ta.billTime < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd')\n" +
                "group by  b.orderDept \n" +
                ") a1 \n" +
                "order by ipcltype , deptCode\n";


        return sql;
    }

}
