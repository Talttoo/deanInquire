package com.julong.deanInquire.dto.entity.item;

public class Menu {
    private long MOID;
    private String MONAME;
    private long ACLID;
    private String ACLNAME;
    private String ICON;
    private String URL;

    public long getMOID() {
        return MOID;
    }

    public void setMOID(long MOID) {
        this.MOID = MOID;
    }

    public String getMONAME() {
        return MONAME;
    }

    public void setMONAME(String MONAME) {
        this.MONAME = MONAME;
    }

    public long getACLID() {
        return ACLID;
    }

    public void setACLID(long ACLID) {
        this.ACLID = ACLID;
    }

    public String getACLNAME() {
        return ACLNAME;
    }

    public void setACLNAME(String ACLNAME) {
        this.ACLNAME = ACLNAME;
    }

    public String getICON() {
        return ICON;
    }

    public void setICON(String ICON) {
        this.ICON = ICON;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "MOID=" + MOID +
                ", MONAME='" + MONAME + '\'' +
                ", ACLID=" + ACLID +
                ", ACLNAME='" + ACLNAME + '\'' +
                ", ICON='" + ICON + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}
