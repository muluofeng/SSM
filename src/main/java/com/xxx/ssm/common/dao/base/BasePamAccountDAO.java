package com.xxx.ssm.common.dao.base;

import com.xxx.ssm.common.entities.PamAccount;
import com.xxx.ssm.common.entities.example.pamAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户账号信息表（pam_account表）
 */
public abstract interface BasePamAccountDAO {
    int countByExample(pamAccountExample example);

    int deleteByExample(pamAccountExample example);

    int deleteByPrimaryKey(Integer accountId);

    int insert(PamAccount record);

    int insertSelective(PamAccount record);

    List<PamAccount> selectByExample(pamAccountExample example);

    PamAccount selectByPrimaryKey(Integer accountId);

    int updateByExampleSelective(@Param("record") PamAccount record, @Param("example") pamAccountExample example);

    int updateByExample(@Param("record") PamAccount record, @Param("example") pamAccountExample example);

    int updateByPrimaryKeySelective(PamAccount record);

    int updateByPrimaryKey(PamAccount record);
}