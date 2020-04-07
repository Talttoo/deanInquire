package com.julong.deanInquire.provider;

/**
 * 院长日报
 */
public class DeanDailyProvider {

    /**
     * 当天全院业务动态
     * @return
     */
    public String  selectAllStaffBusinessPartner(){

        String sql = "SELECT  * " +
                "FROM  " +
                "(   SELECT  " +
                "  COUNT (A .ENCOUNTERID) AS ip_inTimes " +
                "  FROM    pa_ip_data_register A  " +
                " WHERE    A .indate >= TRUNC (SYSDATE) - 1  " +
                " AND A .indate < TRUNC (SYSDATE) + 1  " +
                ") table1 " +
                "LEFT JOIN" +
                " (  SELECT   " +
                "COUNT (1) AS ip_existTimes " +
                " FROM   PA_IP_DATA_WARDPATIENT A " +
                " WHERE   A .OUTWAY IS NULL  AND A .ISCURRENT = '1' " +
                " ) table2" +
                " ON 1 = 1 " +
                "LEFT JOIN " +
                "(  SELECT  " +
                " COUNT (1) AS ip_totalBed,  " +
                " SUM (    CASE    WHEN status IN (2, 3, 5) THEN     1    ELSE     0    END   ) AS ip_useBed " +
                " FROM   sc_bed  WHERE   isdelete = '0' " +
                ") table3 " +
                "ON 1 = 1" +
                " LEFT JOIN " +
                "(  SELECT  " +
                " COUNT (A .ENCOUNTERID) AS ip_outTimes " +
                " FROM   pa_ip_data_register A  " +
                "WHERE   A .OUTDATE >= TRUNC (SYSDATE) - 1  AND A .OUTDATE < TRUNC (SYSDATE) + 1 ) " +
                "table4" +
                " ON 1 = 1" +
                " LEFT JOIN " +
                "(  SELECT  " +
                " SUM (    CASE    WHEN INSTR (b.CATANAME, '急') = 0 THEN     1    ELSE     0    END   ) AS cl_GOPTimes," +
                "   SUM (    CASE    WHEN INSTR (b.CATANAME, '急') > 0 THEN     1    ELSE     0    END   ) AS cl_ERTimes  " +
                "FROM   pa_cl_data_register A,  " +
                " PC_REGISTERCATALOG b  WHERE   A .regtime >= TRUNC (SYSDATE) - 1  AND A .regtime < TRUNC (SYSDATE) + 1 " +
                " AND (   A .regStatus = 1   OR A .regStatus = 2  ) " +
                " AND A .cancelTime IS NULL  AND A .REGCATALOG = b.CATAID " +
                ") table5 " +
                "ON 1 = 1 " +
                "LEFT JOIN ( " +
                " SELECT   " +
                "SUM (b.TOTALSUM) AS ip_totalFee, " +
                "  SUM (    CASE    WHEN c.CATANAME LIKE '%药%' THEN     b.totalsum    ELSE     0    END   ) AS ip_drugFee " +
                " FROM   AB_IP_DATA_CHARGE A,   AB_IP_DATA_CHARGEENTRY b,   AB_BASICCATALOG c" +
                "  WHERE   A .CHARGETIME >= TRUNC (SYSDATE) - 1  AND A .CHARGETIME < TRUNC (SYSDATE) + 1 " +
                " AND A .ISDELETE = '0' " +
                " AND A .CHARGEID = b.CHARGEID  AND b.cataid = c.cataid" +
                " ) table6" +
                " ON 1 = 1 " +
                "LEFT JOIN " +
                "(  SELECT  " +
                " COUNT (DISTINCT A .recipeid) AS cl_times,  " +
                " SUM (b.amount) AS cl_totalFee,  " +
                " SUM (    CASE    WHEN b.entryType IN (3, 4, 5) THEN     b.amount    ELSE     0    END   ) AS cl_drugFee " +
                " FROM   pc_cl_data_Recipe A,   pc_cl_data_RecipeEntry b" +
                "  WHERE   A .recipeID = b.recipeID  AND A .isDelete = '0' " +
                " AND A .chargeTime >= TRUNC (SYSDATE) - 1 " +
                " AND A .chargeTime < TRUNC (SYSDATE) + 1 " +
                " AND A .isCharge = '1'  AND b.isCharge = '1' " +
                " AND A .recipeType <> '9'  AND A .docID IS NOT NULL " +
                ") table7 " +
                "ON 1 = 1";

        return sql;
    }

    /**
     * 门诊人次每日动态
     * @param regDate
     * @return
     */
    public String  selectClDailyDynamicsPartner(String regDate){
        String sql = "SELECT\n" +
                "\tSUM (\n" +
                "\t\tCASE\n" +
                "\t\tWHEN INSTR (b.CATANAME, '急') = 0 THEN\n" +
                "\t\t\t1\n" +
                "\t\tELSE\n" +
                "\t\t\t0\n" +
                "\t\tEND\n" +
                "\t) AS GOPTimes,\n" +
                "\tSUM (\n" +
                "\t\tCASE\n" +
                "\t\tWHEN INSTR (b.CATANAME, '急') > 0 THEN\n" +
                "\t\t\t1\n" +
                "\t\tELSE\n" +
                "\t\t\t0\n" +
                "\t\tEND\n" +
                "\t) AS ERTimes,\n" +
                "\tTO_CHAR (A .regtime, 'hh24') AS HOUR,\n" +
                "\tTO_CHAR (A .regtime, 'yyyy-MM-dd') AS regdate\n" +
                "FROM\n" +
                "\tpa_cl_data_register A,\n" +
                "\tPC_REGISTERCATALOG b\n" +
                "WHERE\n" +
                "\tA .regtime >= TO_DATE ('" +
                regDate+
                "', 'yyyy-MM-dd')\n" +
                "AND A .regtime < " +
                "\tTO_DATE ('" +
                regDate+
                "', 'yyyy-MM-dd')\n" +
                " + 1 and (\n" +
                "\tA .regStatus = 1\n" +
                "\tOR A .regStatus = 2\n" +
                ")\n" +
                "AND A .cancelTime IS NULL\n" +
                "AND A .REGCATALOG = b.CATAID\n" +
                "GROUP BY\n" +
                "\tTO_CHAR (A .regtime, 'yyyy-MM-dd'),\n" +
                "\tTO_CHAR (A .regtime, 'hh24')\n" +
                "ORDER BY\n" +
                "\tregdate,\n" +
                "\tHOUR";

        return sql;
    }

    /**
     * 门诊药房候药队列
     * @return
     */
    public String  selectClWaitingQueuePartner(){
        String sql = "SELECT\n" +
                "\tqueueid,\n" +
                "\trecipeid,\n" +
                "\tNAME,\n" +
                "\twincode,\n" +
                "\twinname,\n" +
                "\tDENSE_RANK () OVER (\n" +
                "\t\tPARTITION BY wincode\n" +
                "\t\tORDER BY\n" +
                "\t\t\tqueueid\n" +
                "\t) AS rowno\n" +
                "FROM\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tA .queueid,\n" +
                "\t\t\tA .recipeid,\n" +
                "\t\t\tA . NAME,\n" +
                "\t\t\tb.wincode,\n" +
                "\t\t\tb.winname\n" +
                "\t\tFROM\n" +
                "\t\t\tMA_CL_DATA_PHARMACYQUEUE A,\n" +
                "\t\t\tOM_WINDOW b\n" +
                "\t\tWHERE\n" +
                "\t\t\tA .windowID = b.WINID\n" +
                "\t\tAND A .QUEUESTATUS IN (1, 2, 3)\n" +
                "\t\tAND A .queueTime > (SYSDATE - 1)\n" +
                "\t\tAND b.WINTYPE = 3\n" +
                "\t\tAND b.ISDELETE = '0'\n" +
                "\t\tUNION ALL\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tA .queueid,\n" +
                "\t\t\t\tA .recipeid,\n" +
                "\t\t\t\tA . NAME,\n" +
                "\t\t\t\tb.wincode,\n" +
                "\t\t\t\tb.winname\n" +
                "\t\t\tFROM\n" +
                "\t\t\t\tMA_CL_DATA_PHARMACYQUEUE A,\n" +
                "\t\t\t\tOM_WINDOW b\n" +
                "\t\t\tWHERE\n" +
                "\t\t\t\tA .windowID = b.WINID\n" +
                "\t\t\tAND A .QUEUESTATUS IN (1, 2, 3)\n" +
                "\t\t\tAND A .queueTime > (SYSDATE - 1)\n" +
                "\t\t\tAND b.WINTYPE = 5\n" +
                "\t\t\tAND b.ISDELETE = '0'\n" +
                "\t)";
        return sql;
    }
}
