package com.julong.deanInquire.provider;

/**
 * 疾病分析
 */
public class DsDiseaseAnalysisProvider {

    /**
     * 疾病年龄段分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectDiseaseAgePartner(String startTime,String endTime){
        String sql = "select rowNum , a1.* \n" +
                "from (\n" +
                "\tselect  a.diagName ,\n" +
                "\t\tcount(DISTINCT a.ENCOUNTERID)  as times  ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 < 10 then a.ENCOUNTERID else null end) as \"zeroToNine\" , \n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 10 and months_between(b.indate , b.birthday)/12 < 20 then a.ENCOUNTERID else null end) as \"tenToNineteen\"  ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 20 and months_between(b.indate , b.birthday)/12 < 30 then a.ENCOUNTERID else null end) as \"twentyToTwentyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 30 and months_between(b.indate , b.birthday)/12 < 40 then a.ENCOUNTERID else null end) as \"thirtyToThirtyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 40 and months_between(b.indate , b.birthday)/12 < 50 then a.ENCOUNTERID else null end) as \"fortyToFortyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 50 and months_between(b.indate , b.birthday)/12 < 60 then a.ENCOUNTERID else null end) as \"fiftyToFiftyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 60 and months_between(b.indate , b.birthday)/12 < 70 then a.ENCOUNTERID else null end) as \"sixtyToSixtyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 70 and months_between(b.indate , b.birthday)/12 < 80 then a.ENCOUNTERID else null end) as \"seventyToSeventyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 80 and months_between(b.indate , b.birthday)/12 < 90 then a.ENCOUNTERID else null end) as \"eightyToEightyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 90 and months_between(b.indate , b.birthday)/12 < 100 then a.ENCOUNTERID else null end) as \"ninetyToNinetyNine\" ,\n" +
                "\t\tcount(DISTINCT case when months_between(b.indate , b.birthday)/12 >= 100  then a.ENCOUNTERID else null end) as \"hundred\" \n" +
                "\tfrom PC_IP_DATA_DIAGNOSEENTRY a , PA_IP_DATA_REGISTER b\n" +
                "\twhere a.DIAGICD10 is not null and\n" +
                "\t\ta.ENCOUNTERID = b.ENCOUNTERID and \n" +
                "\t\tb.birthday is not null and\n" +
                "\t\tb.ISDELETE = '0' and\n" +
                "\t\ta.DIAGDATE >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\t\ta.DIAGDATE < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd')  \n" +
                "\tgroup by  a.DIAGNAME\n" +
                "\torder by times desc\n" +
                ") a1\n" +
                "where rownum <= 500\n";


        return sql;
    }

    /**
     * 疾病金额人次分析
     * @param startTime
     * @param endTime
     * @return
     */
    public String selectDiseaseAmountProvider(String startTime,String endTime){
        String sql = "select rownum , a1.* \n" +
                "from (\n" +
                "\tselect  a.DIAGNAME , count(DISTINCT a.ENCOUNTERID)  as times , sum(b.totalsum) as total\n" +
                "\tfrom PC_IP_DATA_DIAGNOSEENTRY a , AB_IP_DATA_CHARGE b\n" +
                "\twhere a.DIAGICD10 is not null and\n" +
                "\t\ta.ENCOUNTERID = b.ENCOUNTERID(+) and \n" +
                "\t\tb.ISDELETE = '0' and \n" +
                "\t\ta.DIAGDATE >= trunc(to_date('" +
                startTime +
                "','yyyy-mm-dd'),'dd') and \n" +
                "\t\ta.DIAGDATE < trunc(to_date('" +
                endTime +
                "','yyyy-mm-dd'),'dd')  \n" +
                "\tgroup by  a.DIAGNAME\n" +
                "\torder by times desc , total\n" +
                ") a1\n" +
                "where rownum <= 500\n";

        return sql;
    }
}
