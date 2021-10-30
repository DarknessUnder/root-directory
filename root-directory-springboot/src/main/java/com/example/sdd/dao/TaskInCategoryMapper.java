package com.example.sdd.dao;

import com.example.sdd.entity.TaskInCategory;

public interface TaskInCategoryMapper {
    int insert(TaskInCategory record);

    int insertSelective(TaskInCategory record);
}