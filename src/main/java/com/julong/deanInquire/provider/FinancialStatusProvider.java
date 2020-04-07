package com.julong.deanInquire.provider;

/**
 * 财务状况
 */
public class FinancialStatusProvider {

    /**
     * 全院收入分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectHospitalIncomePartner(String startTime, String endTime, int dept,int type ){

        String sql = "";
        //dept：0全院，1门诊，2住院 ；
        //type: 0全部收入，1药品收入，2医疗收入
        switch (dept){
           case  0:
               if(type==1){//全院，药品收入
                    sql = "SELECT\n" +
                            "\t'001' AS deptCode,\n" +
                            "\t'门诊科室' AS deptName,\n" +
                            "\tSUM (\n" +
                            "\t\tCASE\n" +
                            "\t\tWHEN c.CATANAME LIKE '%药%' THEN\n" +
                            "\t\t\tb.totalsum\n" +
                            "\t\tELSE\n" +
                            "\t\t\t0\n" +
                            "\t\tEND\n" +
                            "\t) AS total\n" +
                            "FROM\n" +
                            "\tAB_CL_DATA_CHARGE A,\n" +
                            "\tAB_CL_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "UNION ALL\n" +
                            "\tSELECT\n" +
                            "\t\t'002' AS deptCode,\n" +
                            "\t\t'住院科室' AS deptName,\n" +
                            "\t\tSUM (\n" +
                            "\t\t\tCASE\n" +
                            "\t\t\tWHEN c.CATANAME LIKE '%药%' THEN\n" +
                            "\t\t\t\tb.totalsum\n" +
                            "\t\t\tELSE\n" +
                            "\t\t\t\t0\n" +
                            "\t\t\tEND\n" +
                            "\t\t) AS total\n" +
                            "\tFROM\n" +
                            "\t\tAB_IP_DATA_CHARGE A,\n" +
                            "\t\tAB_IP_DATA_CHARGEENTRY b,\n" +
                            "\t\tAB_BASICCATALOG c\n" +
                            "\tWHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "\tAND A .ISDELETE = '0'\n" +
                            "\tAND A .CHARGEID = b.CHARGEID\n" +
                            "\tAND b.cataid = c.cataid\n" +
                            "\tORDER BY\n" +
                            "\t\tdeptCode";
               }else if(type==2){//全院，医疗收入
                    sql = "SELECT\n" +
                            "\t'001' AS deptCode,\n" +
                            "\t'门诊科室' AS deptName,\n" +
                            "\tSUM (\n" +
                            "\t\tCASE\n" +
                            "\t\tWHEN c.CATANAME NOT LIKE '%药%' THEN\n" +
                            "\t\t\tb.totalsum\n" +
                            "\t\tELSE\n" +
                            "\t\t\t0\n" +
                            "\t\tEND\n" +
                            "\t) AS total\n" +
                            "FROM\n" +
                            "\tAB_CL_DATA_CHARGE A,\n" +
                            "\tAB_CL_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "UNION ALL\n" +
                            "\tSELECT\n" +
                            "\t\t'002' AS deptCode,\n" +
                            "\t\t'住院科室' AS deptName,\n" +
                            "\t\tSUM (\n" +
                            "\t\t\tCASE\n" +
                            "\t\t\tWHEN c.CATANAME NOT LIKE '%药%' THEN\n" +
                            "\t\t\t\tb.totalsum\n" +
                            "\t\t\tELSE\n" +
                            "\t\t\t\t0\n" +
                            "\t\t\tEND\n" +
                            "\t\t) AS total\n" +
                            "\tFROM\n" +
                            "\t\tAB_IP_DATA_CHARGE A,\n" +
                            "\t\tAB_IP_DATA_CHARGEENTRY b,\n" +
                            "\t\tAB_BASICCATALOG c\n" +
                            "\tWHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "\tAND A .ISDELETE = '0'\n" +
                            "\tAND A .CHARGEID = b.CHARGEID\n" +
                            "\tAND b.cataid = c.cataid\n" +
                            "\tORDER BY\n" +
                            "\t\tdeptCode";
               }else {//全院，全部收入
                   sql = "select   \t'001' as deptCode , " +
                           " \t'门诊科室' as deptName ," +
                           "  sum(b.TOTALSUM) as total " +
                           " from AB_CL_DATA_CHARGE a , AB_CL_DATA_CHARGEENTRY b , AB_BASICCATALOG c " +
                           " where a.CHARGETIME >= trunc(to_date('" +
                           startTime+
                           "','yyyy-mm-dd'),'dd') " +
                           "and   \ta.CHARGETIME < trunc(to_date('" +
                           endTime+
                           "','yyyy-mm-dd'),'dd')" +
                           " and   \ta.ISDELETE = '0' " +
                           "and   \ta.CHARGEID = b.CHARGEID " +
                           "and  \tb.cataid = c.cataid  " +
                           "union all " +
                           " select   \t'002' as deptCode ," +
                           "  \t'住院科室' as deptName , " +
                           " sum(b.TOTALSUM) as total " +
                           " from AB_IP_DATA_CHARGE a , AB_IP_DATA_CHARGEENTRY b , AB_BASICCATALOG c " +
                           " where a.CHARGETIME >= trunc(to_date('" +
                           startTime+
                           "','yyyy-mm-dd'),'dd') " +
                           "and   \ta.CHARGETIME < trunc(to_date('" +
                           endTime+
                           "','yyyy-mm-dd'),'dd') " +
                           "and   \ta.ISDELETE = '0' " +
                           "and   \ta.CHARGEID = b.CHARGEID " +
                           "and  \tb.cataid = c.cataid  " +
                           "order by deptCode";
               }
                break;
            case 1:
                if(type==1){//门诊，药品收入
                    sql="SELECT\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptcode\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptCode,\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptname\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptName,\n" +
                            "\tSUM (\n" +
                            "\t\tCASE\n" +
                            "\t\tWHEN c.CATANAME LIKE '%药%' THEN\n" +
                            "\t\t\tb.totalsum\n" +
                            "\t\tELSE\n" +
                            "\t\t\t0\n" +
                            "\t\tEND\n" +
                            "\t) AS total\n" +
                            "FROM\n" +
                            "\tAB_CL_DATA_CHARGE A,\n" +
                            "\tAB_CL_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd') < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "GROUP BY\n" +
                            "\tb.deptid\n" +
                            "ORDER BY\n" +
                            "\tdeptCode";
                }else if(type==2){//门诊，医疗收入
                    sql="SELECT\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptcode\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptCode,\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptname\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptName,\n" +
                            "\tSUM (\n" +
                            "\t\tCASE\n" +
                            "\t\tWHEN c.CATANAME NOT LIKE '%药%' THEN\n" +
                            "\t\t\tb.totalsum\n" +
                            "\t\tELSE\n" +
                            "\t\t\t0\n" +
                            "\t\tEND\n" +
                            "\t) AS total\n" +
                            "FROM\n" +
                            "\tAB_CL_DATA_CHARGE A,\n" +
                            "\tAB_CL_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd') < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "GROUP BY\n" +
                            "\tb.deptid\n" +
                            "ORDER BY\n" +
                            "\tdeptCode";
                }else {//门诊，全部收入
                    sql="SELECT\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptcode\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptCode,\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptname\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptName,\n" +
                            "\tSUM (b.TOTALSUM) AS total\n" +
                            "FROM\n" +
                            "\tAB_CL_DATA_CHARGE A,\n" +
                            "\tAB_CL_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd') < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "GROUP BY\n" +
                            "\tb.deptid\n" +
                            "ORDER BY\n" +
                            "\tdeptCode";
                }
                break;
            case 2:
                if(type==1){//住院，药品收入
                    sql = "SELECT\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptcode\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptCode,\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptname\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptName,\n" +
                            "\tSUM (\n" +
                            "\t\tCASE\n" +
                            "\t\tWHEN c.CATANAME LIKE '%药%' THEN\n" +
                            "\t\t\tb.totalsum\n" +
                            "\t\tELSE\n" +
                            "\t\t\t0\n" +
                            "\t\tEND\n" +
                            "\t) AS total\n" +
                            "FROM\n" +
                            "\tAB_IP_DATA_CHARGE A,\n" +
                            "\tAB_IP_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd') < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "GROUP BY\n" +
                            "\tb.deptid\n" +
                            "ORDER BY\n" +
                            "\tdeptCode";
                }else if(type==2){//住院，医疗收入
                    sql = "SELECT\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptcode\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptCode,\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptname\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptName,\n" +
                            "\tSUM (\n" +
                            "\t\tCASE\n" +
                            "\t\tWHEN c.CATANAME NOT LIKE '%药%' THEN\n" +
                            "\t\t\tb.totalsum\n" +
                            "\t\tELSE\n" +
                            "\t\t\t0\n" +
                            "\t\tEND\n" +
                            "\t) AS total\n" +
                            "FROM\n" +
                            "\tAB_IP_DATA_CHARGE A,\n" +
                            "\tAB_IP_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd') < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "GROUP BY\n" +
                            "\tb.deptid\n" +
                            "ORDER BY\n" +
                            "\tdeptCode";
                }else {//住院，全部收入
                    sql="SELECT\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptcode\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptCode,\n" +
                            "\t(\n" +
                            "\t\tSELECT\n" +
                            "\t\t\tdeptname\n" +
                            "\t\tFROM\n" +
                            "\t\t\tOM_DEPARTMENT\n" +
                            "\t\tWHERE\n" +
                            "\t\t\tdeptid = b.deptid\n" +
                            "\t) AS deptName,\n" +
                            "\tSUM (b.TOTALSUM) AS total\n" +
                            "FROM\n" +
                            "\tAB_IP_DATA_CHARGE A,\n" +
                            "\tAB_IP_DATA_CHARGEENTRY b,\n" +
                            "\tAB_BASICCATALOG c\n" +
                            "WHERE\n" +
                            "\tA .CHARGETIME >= TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .CHARGETIME < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND TRUNC (\"TO_DATE\"('" +
                            startTime +
                            "','yyyy-mm-dd'), 'dd') < TRUNC (\"TO_DATE\"('" +
                            endTime +
                            "','yyyy-mm-dd'), 'dd')\n" +
                            "AND A .ISDELETE = '0'\n" +
                            "AND A .CHARGEID = b.CHARGEID\n" +
                            "AND b.cataid = c.cataid\n" +
                            "GROUP BY\n" +
                            "\tb.deptid\n" +
                            "ORDER BY\n" +
                            "\tdeptCode";
                }
                break;
             default:
                 break;

        }



        return sql;
    }

    /**
     * 出院病人欠款坏账分析-科室分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectPatientArrearsByDeptPartner(String startTime,String endTime){
        String sql = "select  " +
                " (select deptcode from OM_DEPARTMENT where deptid = a2.deptid) as deptCode , " +
                " (select deptname from OM_DEPARTMENT where deptid = a2.deptid) as deptName , " +
                " sum(a2.total) as total ,  sum(a2.deposit) as deposit " +
                "from " +
                "(  select    a1.deptid as deptid,   " +
                " (select sum (amount) from AB_IP_DATA_BILL c    where c.isCharge = '0' and      encounterid = a1.encounterid) as total ,    " +
                " (select sum(amount) from AB_IP_DATA_DEPOSIT b     where b.depositStatus = 1 and      encounterid = a1.encounterid) as deposit " +
                " from (  select a.encounterid as encounterid , a.outDept as deptid " +
                " from" +
                " PA_IP_DATA_REGISTER a " +
                " where a.isMedicalCharge = '1'" +
                " and   a.isCharge = '0' " +
                "and    a.outDate >= trunc(to_date('" +
                startTime+
                "','yyyy-mm-dd'),'dd') " +
                "and    a.outDate < trunc(to_date('" +
                endTime+
                "','yyyy-mm-dd'),'dd')  " +
                " ) a1 " +
                ") a2 " +
                "group by a2.deptid";

        return sql;
    }



    /**
     * 出院病人欠款坏账分析-病人清单
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectPatientArrearsByPatientPartner(String startTime,String endTime){
        String sql = "select \n" +
                "\ta1.encounterID as encounterID,\n" +
                "\ta1.ipNo as ipNo,\n" +
                "\ta1.ipCount as ipCount,\n" +
                "\ta1.name,\n" +
                "\tto_char(a1.inDate,'YYYY-MM-DD') as inDate ,\n" +
                "\tto_char(a1.outDate,'YYYY-MM-DD') as outDate,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = a1.outDept) as deptName ,\n" +
                "\t(select sum (amount) from AB_IP_DATA_BILL c\n" +
                "\t\twhere c.isCharge = '0' and \n" +
                "\t\t\tencounterid = a1.encounterid) as total , \n" +
                "\n" +
                "\t(select sum(amount) from AB_IP_DATA_DEPOSIT b \n" +
                "\t\twhere b.depositStatus = 1 and \n" +
                "\t\t\tencounterid = a1.encounterid) as deposit\n" +
                "from (\n" +
                "select *\n" +
                "from PA_IP_DATA_REGISTER a\n" +
                "where a.isMedicalCharge = '1' and\n" +
                "\ta.isCharge = '0' and \n" +
                "\ta.outDate >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\ta.outDate < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd') \n" +
                ") a1\n" +
                "order by outDate";
        //System.out.println(sql);
        return sql;
    }
}
