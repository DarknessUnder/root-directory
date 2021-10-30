package com.example.sdd.dao;

import com.example.sdd.entity.Grade;

public interface GradeMapper {
    int insert(Grade record);

    int insertSelective(Grade record);
}