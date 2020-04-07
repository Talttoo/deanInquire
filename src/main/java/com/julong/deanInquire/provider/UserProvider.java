package com.julong.deanInquire.provider;

public class UserProvider {

    public String findByUsername(String username){

        String sql = "SELECT  *" +
                " FROM SM_USER" +
                " WHERE \"userName\"='" +
                username+
                "'";
        return sql;
    }
    public String   findByUserCode (String usercode){
        String sql = "SELECT  *" +
                " FROM SM_USER" +
                " WHERE \"USERCODE\"='" +
                usercode+
                "'";
        return sql;
    }

    public String   findMoidByUser (String usercode){
        String sql = "SELECT  DISTINCT a.MOID,a.MONAME\n" +
                "FROM(\n" +
                "SELECT   obj.MOID,obj.MONAME,med.ACLID,med.ACLNAME,men.ICON,men.URL\n" +
                " FROM SM_USER us,SM_USERACL rol,SM_MEDOBJECT obj,SM_MEDACL med,WEIXIN_MENU men\n" +
                " WHERE us.USERCODE ='" +
                usercode +
                "' AND us.USERID = rol.USERID\n" +
                "AND rol.ACLID = med.ACLID AND med.MOID = obj.MOID\n" +
                "AND med.ACLID = MEN.ACLID\n" +
                "UNION \n" +
                "SELECT obj1.MOID ,obj1.MONAME ,med1.ACLID ,med1.ACLNAME ,men1.ICON ,men1.URL \n" +
                "FROM SM_USER us1,SM_ROLEACL rol1,SM_MEDOBJECT obj1,SM_MEDACL med1,WEIXIN_MENU men1\n" +
                "WHERE us1.USERCODE ='" +
                usercode+
                "' AND us1.USERID = rol1.ROLEID\n" +
                "AND rol1.ACLID = med1.ACLID AND med1.MOID = obj1.MOID\n" +
                "AND med1.ACLID = men1.ACLID\n" +
                ")a\n" +
                "ORDER BY MOID";
        return sql;
    }


    public String   showMenuByUser (String usercode){
        String sql = "SELECT   a.MOID,a.MONAME,a.ACLID,a.ACLNAME,a.ICON,a.URL\n" +
                "FROM(\n" +
                "SELECT   obj.MOID,obj.MONAME,med.ACLID,med.ACLNAME,men.ICON,men.URL\n" +
                " FROM SM_USER us,SM_USERACL rol,SM_MEDOBJECT obj,SM_MEDACL med,WEIXIN_MENU men\n" +
                " WHERE us.USERCODE ='" +
                usercode +
                "' AND us.USERID = rol.USERID\n" +
                "AND rol.ACLID = med.ACLID AND med.MOID = obj.MOID\n" +
                "AND med.ACLID = MEN.ACLID\n" +
                "UNION \n" +
                "SELECT obj1.MOID ,obj1.MONAME ,med1.ACLID ,med1.ACLNAME ,men1.ICON ,men1.URL \n" +
                "FROM SM_USER us1,SM_ROLEACL rol1,SM_MEDOBJECT obj1,SM_MEDACL med1,WEIXIN_MENU men1\n" +
                "WHERE us1.USERCODE ='" +
                usercode +
                "' AND us1.USERID = rol1.ROLEID\n" +
                "AND rol1.ACLID = med1.ACLID AND med1.MOID = obj1.MOID\n" +
                "AND med1.ACLID = men1.ACLID\n" +
                ")a\n" +
                "ORDER BY MOID,ACLID";
        return sql;
    }


}
