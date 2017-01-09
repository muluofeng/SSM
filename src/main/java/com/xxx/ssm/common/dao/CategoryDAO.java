package com.xxx.ssm.common.dao;

import com.xxx.ssm.common.entities.category;
import com.xxx.ssm.common.entities.example.categoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryDAO {
    int countByExample(categoryExample example);

    int deleteByExample(categoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(category record);

    int insertSelective(category record);

    List<category> selectByExample(categoryExample example);

    category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") category record, @Param("example") categoryExample example);

    int updateByExample(@Param("record") category record, @Param("example") categoryExample example);

    int updateByPrimaryKeySelective(category record);

    int updateByPrimaryKey(category record);
}