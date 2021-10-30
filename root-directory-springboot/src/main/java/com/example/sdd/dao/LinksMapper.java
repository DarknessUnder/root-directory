package com.example.sdd.dao;

import com.example.sdd.entity.Links;

public interface LinksMapper {
    int insert(Links record);

    int insertSelective(Links record);
}