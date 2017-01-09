package com.xxx.ssm.common.entities;

public class AccountInfo {
    private Integer accountId;

    private String email;

    private String addr;

    private String sex;

    private Integer regtime;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getRegtime() {
        return regtime;
    }

    public void setRegtime(Integer regtime) {
        this.regtime = regtime;
    }
}