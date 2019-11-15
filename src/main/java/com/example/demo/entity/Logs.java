package com.example.demo.entity;

import lombok.ToString;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@ToString
public class Logs {
    private Integer logId;

    private String logOperation;

    private String logMethod;

    private String logParm;

    private Date logTime;

    private Integer logUserid;

    private String logUser;

    private String logIp;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogOperation() {
        return logOperation;
    }

    public void setLogOperation(String logOperation) {
        this.logOperation = logOperation == null ? null : logOperation.trim();
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod == null ? null : logMethod.trim();
    }

    public String getLogParm() {
        return logParm;
    }

    public void setLogParm(String logParm) {
        this.logParm = logParm == null ? null : logParm.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
      //  DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        this.logTime =logTime;
    }

    public Integer getLogUserid() {
        return logUserid;
    }

    public void setLogUserid(Integer logUserid) {
        this.logUserid = logUserid;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser == null ? null : logUser.trim();
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp == null ? null : logIp.trim();
    }
}