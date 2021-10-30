package com.example.sdd.dao;

import com.example.sdd.entity.UserCollection;

public interface UserCollectionMapper {
    int deleteByPrimaryKey(Integer collectionId);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    UserCollection selectByPrimaryKey(Integer collectionId);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}