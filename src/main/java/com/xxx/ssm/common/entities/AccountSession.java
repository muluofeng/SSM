package com.xxx.ssm.common.entities;

import com.xxx.ssm.common.entities.vo.AccountVO;

/**
 * 后台用户登录session信息
 * Created by Administrator on 2016/10/17.
 */
public class AccountSession {
    /**pam_account用户信息数据**/
    private AccountVO accountVO;

    public void setAccountData(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public AccountVO getAccountData() {

        return this.accountVO;
    }
}
