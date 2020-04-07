package com.julong.deanInquire.provider;

/**
 * 住院信息
 */
public class IpInformationProvider {

    /**
     * 1）	住院结算收入分析-日期
     * @param selectTime
     * @return
     */
    public String selectSettlementIncomePartnerbyDate(String selectTime){
        String sql = "select \n" +
                "\ttrunc(CHARGETIME , 'dd')as CHARGETIME,\n" +
                "\textract(day from CHARGETIME) as chargeDay ,\n" +
                "\tsum(totalsum) as totalsum\n" +
                "from AB_IP_DATA_CHARGE a\n" +
                "where a.CHARGETIME >= trunc(to_date('" +
                selectTime +
                "','yyyy-mm'),'mm') and \n" +
                "\ta.CHARGETIME < trunc(ADD_MONTHS(to_date('" +
                selectTime +
                "','yyyy-mm'), 1),'mm') and \n" +
                "\ta.ISDELETE = '0'\n" +
                "group by trunc(CHARGETIME , 'dd') , extract(day from CHARGETIME)\n" +
                "order by chargeDay";

        return sql;
    }

    /**
     * 住院结算收入分析-科室
     * @param selectTime
     * @return
     */
    public String selectSettlementIncomePartnerbyDept(String selectTime){
        String sql ="select \n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = b.deptid) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = b.deptid) as deptName ,\n" +
                "\tsum(b.TOTALSUM) as totalsum\n" +
                "from AB_IP_DATA_CHARGE a , AB_IP_DATA_CHARGEENTRY b\n" +
                "where a.CHARGETIME >= trunc(to_date('" +
                 selectTime  +
                "','yyyy-mm'),'mm') and \n" +
                "\ta.CHARGETIME < trunc(ADD_MONTHS(to_date('" +
                selectTime +
                " ','yyyy-mm'), 1),'mm')and \n" +
                "\ta.ISDELETE = '0' and \n" +
                "\ta.CHARGEID = b.CHARGEID\n" +
                "group by b.deptid\n" +
                "order by deptCode\n";

        return sql;
    }


    /**
     *  2）	住院药品收入比例
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectDrugRevenueRatio(String startTime,String endTime){
        String sql = "select \n" +
                "\t(select deptcode from OM_DEPARTMENT where deptid = b.deptid) as deptCode ,\n" +
                "\t(select deptname from OM_DEPARTMENT where deptid = b.deptid) as deptName ,\n" +
                "\tsum(b.TOTALSUM) as totalsum,\n" +
                "\tsum(case when  c.CATANAME like '%药%' then b.totalsum else 0 end) as drugFee\n" +
                "from AB_IP_DATA_CHARGE a , AB_IP_DATA_CHARGEENTRY b , AB_BASICCATALOG c\n" +
                "where a.CHARGETIME >= trunc( to_date( '" +
                startTime+
                " ','yyyy-mm-dd'),'dd') and \n" +
                "\ta.CHARGETIME < trunc( to_date(' " +
                endTime +
                " ','yyyy-mm-dd'),'dd') and \n" +
                "\ta.ISDELETE = '0' and \n" +
                "\ta.CHARGEID = b.CHARGEID and\n" +
                "\tb.cataid = c.cataid\n" +
                "group by b.deptid\n" +
                "order by deptCode\n";
       // System.out.println(sql);
        return sql;
    }
}
