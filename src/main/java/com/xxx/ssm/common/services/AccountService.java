package com.xxx.ssm.common.services;

import com.xxx.ssm.common.entities.vo.AccountVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */
public interface AccountService {
    /**
     * 根据条件获取用户信息
     * @param map ： login_name  account_id
     * @return
     */
    public AccountVO getAccountInfo(HashMap map);

    public List<AccountVO> getAccountVoList(HashMap map);
    /**
     * 保存用户信息
     * @param map
     */
    public int saveAccount(HashMap map);

    /**
     * 删除后台用户
     * @param accountId
     * @return
     */
    public int deleteAccountById(int accountId);

}
