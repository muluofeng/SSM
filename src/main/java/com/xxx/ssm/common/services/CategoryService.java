package com.xxx.ssm.common.services;

import com.xxx.ssm.common.entities.category;
import com.xxx.ssm.common.entities.example.categoryExample;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface CategoryService {
    public List<category>  getCategoryByName(categoryExample example);
}
