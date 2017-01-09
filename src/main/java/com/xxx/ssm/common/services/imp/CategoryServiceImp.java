package com.xxx.ssm.common.services.imp;

import com.xxx.ssm.common.dao.CategoryDAO;
import com.xxx.ssm.common.entities.category;
import com.xxx.ssm.common.entities.example.categoryExample;
import com.xxx.ssm.common.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDAO dao;

    public List<category> getCategoryByName(categoryExample example) {
        return dao.selectByExample(example);
    }
}
