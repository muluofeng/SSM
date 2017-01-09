package com.xxx.ssm.common.dao;

import com.xxx.ssm.common.entities.vo.AccountVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public interface AccountDAO  {
    //获取用户登录信息，和一些相关的信
     List<AccountVO> getAccountInfo(HashMap map);
}
