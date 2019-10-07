package com.example.demo.entity;

import lombok.ToString;

import java.util.Date;
import java.util.regex.Pattern;
@ToString
public class Admin {
    private Integer aId;

    private String aName;

    private String aPhone;

    private String aMail;

    private String aPassword;

    private Boolean aLimited;

    private String aPhoto;

    private Boolean aState;

    private Date aCt;

    private Date aSt;

    private Date aLst;

    private Integer aCount;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone == null ? null : aPhone.trim();
    }

    public String getaMail() {
        return aMail;
    }

    public void setaMail(String aMail) {
        this.aMail = aMail == null ? null : aMail.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }

    public Boolean getaLimited() {
        return aLimited;
    }

    public void setaLimited(Boolean aLimited) {
        this.aLimited = aLimited;
    }

    public String getaPhoto() {
        return aPhoto;
    }

    public void setaPhoto(String aPhoto) {
        this.aPhoto = aPhoto == null ? null : aPhoto.trim();
    }

    public Boolean getaState() {
        return aState;
    }

    public void setaState(Boolean aState) {
        this.aState = aState;
    }

    public Date getaCt() {
        return aCt;
    }

    public void setaCt(Date aCt) {
        this.aCt = aCt;
    }

    public Date getaSt() {
        return aSt;
    }

    public void setaSt(Date aSt) {
        this.aSt = aSt;
    }

    public Date getaLst() {
        return aLst;
    }

    public void setaLst(Date aLst) {
        this.aLst = aLst;
    }

    public Integer getaCount() {
        return aCount;
    }

    public void setaCount(Integer aCount) {
        this.aCount = aCount;
    }

 /*   public boolean isMail(String account){
        String pattern = "\\w+@{1}\\w+\\.{1}\\w+";
        boolean isMatch = Pattern.matches(pattern, account);
        return isMatch;
    }*/
}