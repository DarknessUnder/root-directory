package com.example.sdd.dao;

import com.example.sdd.entity.UserCourses;

public interface UserCoursesMapper {
    int insert(UserCourses record);

    int insertSelective(UserCourses record);
}