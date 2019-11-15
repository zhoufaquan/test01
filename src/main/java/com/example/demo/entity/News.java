package com.example.demo.entity;

import lombok.ToString;

import java.util.Date;
@ToString
public class News {
    private Integer nId;

    private String nTitle;

    private String nLink;

    private Date nDate;

    private String nText;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle == null ? null : nTitle.trim();
    }

    public String getnLink() {
        return nLink;
    }

    public void setnLink(String nLink) {
        this.nLink = nLink == null ? null : nLink.trim();
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public String getnText() {
        return nText;
    }

    public void setnText(String nText) {
        this.nText = nText == null ? null : nText.trim();
    }
}