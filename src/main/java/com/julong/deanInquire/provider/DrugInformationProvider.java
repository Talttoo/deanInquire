package com.julong.deanInquire.provider;

import java.util.List;

/**
 * 药品信息
 */
public class DrugInformationProvider {

    /**
     *  医生药物金额排行榜
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectDoctorsDrugsPartner(String startTime,String endTime){

        String sql ="select\n" +
                "\t(select usercode from sm_user where userid = docid) as doctorCode ,\n" +
                "\t(select username from sm_user where userid = docid) as doctorName ,\n" +
                "\tsum (cltotal) as cltotal ,\n" +
                "\tsum(iptotal) as iptotal\t, \n" +
                "\tsum(cltotal + iptotal) as total\n" +
                "from (\n" +
                "select b.DOCID as docid ,\n" +
                "\tsum(c.amount) as cltotal , \n" +
                "\t0 as iptotal \n" +
                "from  pc_cl_data_recipe b , pc_cl_data_recipeentry c , AB_ORDERITEM a\n" +
                "where  \n" +
                "\tb.chargetime >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\tb.chargetime < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and  \n" +
                "\tb.ISDELETE = '0' and\n" +
                "\tb.recipeid = c.recipeid and  \n" +
                "\ta.itemid = c.itemid and  \n" +
                "\ta.ISDRUGITEM = '1'   \n" +
                "group by b.DOCID\n" +
                "union all \n" +
                "select \n" +
                "\tc.orderDoctor as docid ,\n" +
                "\t0 as cltotal ,\n" +
                "\tsum(c.amount) as iptotal\n" +
                "from  AB_IP_DATA_BILL c , AB_ORDERITEM a \n" +
                "where  \n" +
                "\tc.billtime >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\tc.billtime < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and  \n" +
                "\ta.itemid = c.itemid and  \n" +
                "\ta.ISDRUGITEM = '1'   \n" +
                "group by  c.orderDoctor\n" +
                ")\n" +
                "group by docid\n" +
                "order by iptotal + cltotal desc\n";

        return sql;

    }

    /**
     *  库存查询
     * @param locId
     * @param drugList
     * @return
     */
    public String selectDrStockInquiryPartner(String locId, List<String> drugList){
        StringBuilder sql = new StringBuilder();
        StringBuilder drugStr  = new StringBuilder();
        sql.append("select    " +
                " \t(select stuffcode from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a.STUFFID ) as stuffcode , " +
                " \t(select stuffname from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a.STUFFID ) as stuffname , " +
                " \t(select standard from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a.STUFFID ) as standard , " +
                "\t(select MA_UNIT.UNITNAME  \t" +
                "\tfrom ma_stufflocation , MA_UNIT  \t\t" +
                "where MA_UNIT.UNITID = ma_stufflocation.UNITID " +
                "and \t\t\tma_stufflocation.stuffid = a.STUFFID " +
                "and \t\t\tma_stufflocation.locid = a.LOCID) as UNITNAME, " +
                " \tsum(a.amount) as quantity, \tsum(a.amount * a.buyprice) as buyAmount , " +
                "\tsum(a.amount * a.saleprice) as saleAmount " +
                " from MA_DATA_STORAGE a , MA_STUFFITEM b " +
                "where a.STUFFID = b.STUFFID" +
                " and  \tb.ISDELETE = '0' " +
                "and \ta.LOCID = '" +
                 locId+
                "'"
               );
        if (drugList.size()>0&&!("1".equals(drugList.get(0)))){
            for (int i=0;i<drugList.size();i++){
                if (i==0){
                    drugStr.append(" '").append(drugList.get(i)).append("'  ");
                }else {
                    drugStr.append(", '").append(drugList.get(i)).append("'  ");
                }

            }
            sql.append("and  b.STUFFCODE in ( ").append(drugStr).append(" ) ");
        }
        sql.append( " group by a.LOCID , a.STUFFID " +
                "order by stuffcode");

        //System.out.println(sql);
        return String.valueOf(sql);
    }

    /**
     * 库房药品入库排行榜
     * @param startTime
     * @param endTime
     * @param deptId
     * @return
     */
    public String selectTreasuryDrugsPartner(String startTime,String endTime,String deptId){
        String sql = "select \t(select stuffcode from MA_STUFFITEM where MA_STUFFITEM.STUFFID = b.itemid ) as itemcode , \n" +
                "\t(select stuffname from MA_STUFFITEM where MA_STUFFITEM.STUFFID = b.itemid ) as itemname , \n" +
                "\t(select standard from MA_STUFFITEM where MA_STUFFITEM.STUFFID = b.itemid ) as standard ,\n" +
                "\t(select MA_UNIT.UNITNAME \n" +
                "\t\tfrom ma_stufflocation , MA_UNIT \n" +
                "\t\twhere MA_UNIT.UNITID = ma_stufflocation.UNITID and\n" +
                "\t\t\tma_stufflocation.stuffid = b.itemid and\n" +
                "\t\t\tma_stufflocation.locid = a.deptid) as UNITNAME, \n" +
                " \tsum(b.QUANTITY) as QUANTITY, \n" +
                "\tsum(b.buyAmount) as amount\n" +
                "from Ma_Data_Voucher a , MA_DATA_VOUCHERENTRY  b , ma_affair c\n" +
                "where a.AFFAIRTYPE = c.AFFAID and \n" +
                "\ta.VOUCHERID = b.VOUCHERID and\n" +
                "\tc.affacatatype = 1 and \n" +
                "\ta.VOUCHERDATE >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and\n" +
                "\ta.VOUCHERDATE < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and\n" +
                "\ta.DEPTID = '" +
                deptId+
                "' and\n" +
                "\ta.ISCONFIRM = '1' and \n" +
                "\ta.isDelete = '0' and \n" +
                "\ta.isDrug = '1'\n" +
                "group by a.deptid , b.itemid\n" +
                "order by amount desc\n";

        //System.out.println(sql);

        return sql;

    }


    /**
     * 库房药品入库排行榜-总合计
     * @param startTime
     * @param endTime
     * @param deptId
     * @return
     */
    public String selectTreasuryDrugsTotalAmountPartner(String startTime,String endTime,String deptId){

        String sql = "select \t(select stuffcode from MA_STUFFITEM where MA_STUFFITEM.STUFFID = b.itemid ) as itemcode , \n" +
                "\tsum(b.buyAmount) as amount\n" +
                "from Ma_Data_Voucher a , MA_DATA_VOUCHERENTRY  b , ma_affair c\n" +
                "where a.AFFAIRTYPE = c.AFFAID and \n" +
                "\ta.VOUCHERID = b.VOUCHERID and\n" +
                "\tc.affacatatype = 1 and \n" +
                "\ta.VOUCHERDATE >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and\n" +
                "\ta.VOUCHERDATE < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and\n" +
                "\ta.DEPTID = '" +
                deptId+
                "' and\n" +
                "\ta.ISCONFIRM = '1' and \n" +
                "\ta.isDelete = '0' and \n" +
                "\ta.isDrug = '1'\n" +
                "group by a.deptid , b.itemid\n" +
                "order by amount desc\n";

        //System.out.println(sql);

        return sql;

    }

    /**
     * 抗生素和基本药品使用分析-获取门诊科室
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectMedicinesClDept(String startTime,String endTime){

        String sql="select \n" +
                "\tDISTINCT(select deptid from OM_DEPARTMENT where deptid = b.deptid) as deptid ,\n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = b.deptid) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = b.deptid) as deptName \n" +
                " from  pc_cl_data_recipe b , pc_cl_data_recipeentry c , AB_ORDERITEM a  , PH_DRUGITEM d  \n" +
                " where  \n" +
                "\tb.chargetime >= trunc(\"TO_DATE\"('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\tb.chargetime < trunc(\"TO_DATE\"('" +
                endTime +
                "','yyyy-mm-dd'),'dd') and  \n" +
                "\tb.ISDELETE = '0' and\n" +
                "\tb.recipeid = c.recipeid and  \n" +
                "\ta.itemid = c.itemid and  \n" +
                "\ta.DRUGITEMID = d.DRUGID and  \n" +
                "\ta.ISDRUGITEM = '1' \n" +
                "order by deptCode ";

        return sql;



    }


    /**
     * 抗生素和基本药品使用分析-获取住院科室
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectMedicinesIpDept(String startTime,String endTime) {

        String sql="select \n" +
                "(select deptid from OM_DEPARTMENT where deptid = c.patientDept) as deptid ,\n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = c.patientDept) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = c.patientDept) as deptName \n" +
                " from  AB_IP_DATA_BILL c , AB_ORDERITEM a  , PH_DRUGITEM d  \n" +
                " where  \n" +
                "\tc.billtime >= trunc(\"TO_DATE\"('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\tc.billtime < trunc(\"TO_DATE\"('" +
                endTime +
                "','yyyy-mm-dd'),'dd') and  \n" +
                "\ta.itemid = c.itemid and  \n" +
                "\ta.DRUGITEMID = d.DRUGID and  \n" +
                "\ta.ISDRUGITEM = '1'   \n" +
                "group by c.patientDept \n" +
                "order by deptCode ";
        return sql;
    }

    /**
     *  抗生素和基本药品使用分析-门诊分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectClMedicines(String startTime,String endTime,String deptId){
        StringBuilder sql = new StringBuilder();
            sql.append( "select \n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = b.deptid) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = b.deptid) as deptName ,\n" +
                "\t(select usercode from sm_user where userid = b.docid) as doctorCode ,\n" +
                "\t(select username from sm_user where userid = b.docid) as doctorName ,\n" +
                "\tsum(case when  d.isAntibacterial = '1' then c.amount else 0 end) as antibacterialFee ,\n" +
                "\tsum(case when  d.genericDrugID is not null then c.amount else 0 end) as genericFee ,\n" +
                "\tsum(c.amount) as total\n" +
                " from  pc_cl_data_recipe b , pc_cl_data_recipeentry c , AB_ORDERITEM a  , PH_DRUGITEM d  \n" +
                " where  \n" +
                "\tb.chargetime >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\tb.chargetime < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and  \n" +
                "\tb.ISDELETE = '0' and\n" +
                "\tb.recipeid = c.recipeid and  \n" +
                "\ta.itemid = c.itemid and  \n" +
                "\ta.DRUGITEMID = d.DRUGID and  \n" +
                "\ta.ISDRUGITEM = '1'  and \n"
            ) ;
            if(deptId==null||"".equals(deptId)){
                sql.append("b.DEPTID IS NULL \n");
            }else{
                sql.append("b.DEPTID = '"+deptId+"' \n");
            }
                sql.append("\tgroup by b.DEPTID , b.DOCID\n" +
                        " \torder by deptCode , doctorCode\n");


        //System.out.println(sql);

        return String.valueOf(sql);
    }

    /**
     *  抗生素和基本药品使用分析-住院分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectIpMedicines(String startTime,String endTime,String deptId){
        StringBuilder sql = new StringBuilder();
         sql.append( "select \n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = c.patientDept) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = c.patientDept) as deptName ,\n" +
                "\t(select usercode from sm_user where userid = c.orderDoctor) as doctorCode ,\n" +
                "\t(select username from sm_user where userid = c.orderDoctor) as doctorName ,\n" +
                "\tsum(case when  d.isAntibacterial = '1' then c.amount else 0 end) as antibacterialFee ,\n" +
                "\tsum(case when  d.genericDrugID is not null then c.amount else 0 end) as genericFee ,\n" +
                "\tsum(c.amount) as total\n" +
                " from  AB_IP_DATA_BILL c , AB_ORDERITEM a  , PH_DRUGITEM d  \n" +
                " where  \n" +
                "\tc.billtime >= trunc(\"TO_DATE\"('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\tc.billtime < trunc(\"TO_DATE\"('" +
                endTime +
                "','yyyy-mm-dd'),'dd') and  \n" +
                "\ta.itemid = c.itemid and  \n" +
                "\ta.DRUGITEMID = d.DRUGID and  \n" +
                "\ta.ISDRUGITEM = '1'  and \n" );
            if(deptId==null||"".equals(deptId)){
                sql.append("c.patientDept IS NULL \n");
            }else{
                sql.append("c.patientDept = '"+deptId+"'\n");
            }
            sql.append("\tgroup by c.patientDept , c.orderDoctor\n" +

                    "\torder by deptCode , doctorCode\n");
        //System.out.println(sql);

        return String.valueOf(sql);
    }


    /**
     *  药房药品消耗排行榜
     * @param startTime
     * @param endTime
     * @param locId
     * @return
     */
    public String selectDrugConsumption(String startTime,String endTime,String locId){
        String sql = "select a1.ITEMID ,\n" +
                "\t(select stuffcode from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a1.itemid ) as itemcode , \n" +
                "\t(select stuffname from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a1.itemid ) as itemname , \n" +
                "\t(select standard from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a1.itemid ) as standard , \n" +
                "\t(select MA_UNIT.UNITNAME \n" +
                "\t\tfrom ma_stufflocation , MA_UNIT \n" +
                "\t\twhere MA_UNIT.UNITID = ma_stufflocation.UNITID and\n" +
                "\t\t\tma_stufflocation.stuffid = a1.itemid and\n" +
                "\t\t\tma_stufflocation.locid = a1.locid) as UNITNAME, \n" +
                "\tsum(a1.QUANTITY) as QUANTITY ,\n" +
                "\tsum(ROUND(a1.QUANTITY * a1.SALEPRICE , 2)) as amount\n" +
                "from (\n" +
                "\tselect a.ITEMID ,\n" +
                "\t\ta.locid ,\n" +
                "\t\ta.QUANTITY,\n" +
                "\t\ta.SALEPRICE\n" +
                "\tfrom MA_CL_DATA_DISPENSE a \n" +
                "\twhere a.DISPENSETIME >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and\n" +
                "\t\ta.DISPENSETIME < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\t\ta.locid = '" +
                locId+
                "'\n" +
                "\tunion all \n" +
                "\tselect a.ITEMID ,\n" +
                "\t\ta.locid ,\n" +
                "\t\ta.QUANTITY,\n" +
                "\t\ta.SALEPRICE\n" +
                "\tfrom MA_IP_DATA_DISPENSE a \n" +
                "\twhere a.DISPENSETIME >= trunc(to_date('" +
                 startTime +
                " ','yyyy-mm-dd'),'dd') and\n" +
                "\t\ta.DISPENSETIME < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\t\ta.locid = '" +
                locId+
                "'\n" +
                ") a1\n" +
                "group by a1.ITEMID , a1.locid\n" +
                "order by amount desc\n";

       // System.out.println(sql);
        return sql;
    }


    /**
     *  药房药品消耗排行榜-总合计
     * @param startTime
     * @param endTime
     * @param locId
     * @return
     */
    public String selectDrugConsumptionForSum(String startTime,String endTime,String locId){

      //  System.out.println(startTime+"-"+endTime+" locId: "+locId+"获取总合计");
        String sql = "select a1.ITEMID ,\n" +
                "\t(select stuffcode from MA_STUFFITEM where MA_STUFFITEM.STUFFID = a1.itemid ) as itemcode , \n" +
                "\tsum(ROUND(a1.QUANTITY * a1.SALEPRICE , 2)) as amount\n" +
                "from (\n" +
                "\tselect a.ITEMID ,\n" +
                "\t\ta.locid ,\n" +
                "\t\ta.QUANTITY,\n" +
                "\t\ta.SALEPRICE\n" +
                "\tfrom MA_CL_DATA_DISPENSE a \n" +
                "\twhere a.DISPENSETIME >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') and\n" +
                "\t\ta.DISPENSETIME < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\t\ta.locid = '" +
                locId+
                "'\n" +
                "\tunion all \n" +
                "\tselect a.ITEMID ,\n" +
                "\t\ta.locid ,\n" +
                "\t\ta.QUANTITY,\n" +
                "\t\ta.SALEPRICE\n" +
                "\tfrom MA_IP_DATA_DISPENSE a \n" +
                "\twhere a.DISPENSETIME >= trunc(to_date('" +
                startTime +
                " ','yyyy-mm-dd'),'dd') and\n" +
                "\t\ta.DISPENSETIME < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd') and \n" +
                "\t\ta.locid = '" +
                locId+
                "'\n" +
                ") a1\n" +
                "group by a1.ITEMID , a1.locid\n" +
                "order by amount desc\n";


//        String sql = "select b1.ITEMID ,\n" +
//                "\t(select stuffcode from MA_STUFFITEM where MA_STUFFITEM.STUFFID = b1.itemid ) as itemcode , \n" +
//                "\tsum(ROUND(b1.QUANTITY * b1.SALEPRICE , 2)) as amount\n" +
//                "from (\n" +
//                "\tselect a.ITEMID ,\n" +
//                "\t\ta.locid ,\n" +
//                "\t\ta.QUANTITY,\n" +
//                "\t\ta.SALEPRICE\n" +
//                "\tfrom MA_CL_DATA_DISPENSE a \n" +
//                "\twhere a.DISPENSETIME >= trunc(to_date('" +
//                startTime+
//                "','yyyy-mm-dd'),'dd') and\n" +
//                "\t\ta.DISPENSETIME < trunc(to_date('" +
//                endTime+
//                "','yyyy-mm-dd'),'dd') and \n" +
//                "\t\ta.locid = '" +
//                locId+
//                "'\n" +
//                "\tunion all \n" +
//                "\tselect a.ITEMID ,\n" +
//                "\t\ta.locid ,\n" +
//                "\t\ta.QUANTITY,\n" +
//                "\t\ta.SALEPRICE\n" +
//                "\tfrom MA_IP_DATA_DISPENSE a \n" +
//                "\twhere a.DISPENSETIME >= trunc(to_date('" +
//                startTime +
//                " ','yyyy-mm-dd'),'dd') and\n" +
//                "\t\ta.DISPENSETIME < trunc(to_date('" +
//                endTime+
//                "','yyyy-mm-dd'),'dd') and \n" +
//                "\t\ta.locid = '" +
//                locId+
//                "'\n" +
//                ") b1\n" +
//                "group by b1.ITEMID , b1.locid\n" +
//                "order by amount desc\n";

         //System.out.println(sql);
        return sql;
    }
}
