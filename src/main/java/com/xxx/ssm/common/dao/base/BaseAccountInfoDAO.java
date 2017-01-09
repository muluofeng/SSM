package com.xxx.ssm.common.dao.base;

import com.xxx.ssm.common.entities.AccountInfo;
import com.xxx.ssm.common.entities.example.AccountInfoExample;
import org.apache.ibatis.annotations.Param;
/**
 * 后台用户信息对象（account_id表）
 */
import java.util.List;

public interface BaseAccountInfoDAO {
    int countByExample(AccountInfoExample example);

    int deleteByExample(AccountInfoExample example);

    int deleteByPrimaryKey(Integer accountId);

    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    List<AccountInfo> selectByExample(AccountInfoExample example);

    AccountInfo selectByPrimaryKey(Integer accountId);

    int updateByExampleSelective(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);

    int updateByExample(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);
}