package com.example.sdd.dao;

import com.example.sdd.entity.CourseTask;

public interface CourseTaskMapper {
    int insert(CourseTask record);

    int insertSelective(CourseTask record);
}