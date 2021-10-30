package com.example.sdd.dao;

import com.example.sdd.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer taskCategoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer taskCategoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}