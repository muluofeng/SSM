package com.xxx.ssm.common.entities.vo;

import com.xxx.ssm.common.entities.PamAccount;

/**
 * Created by Administrator on 2016/10/26.
 *后台账号信息实体类(pam_account和account_info)
 */
public class AccountVO extends PamAccount {
    private String email;
    private String addr;
    private String sex;
    private int regtime;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRegtime() {
        return regtime;
    }

    public void setRegtime(int regtime) {
        this.regtime = regtime;
    }
}
