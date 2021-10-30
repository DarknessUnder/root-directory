package com.example.sdd.dao;

import com.example.sdd.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where " +
            "user_name = #{userName,jdbcType=VARCHAR} " +
            "AND password=#{password,jdbcType=VARCHAR} ")
    User login(@Param("userName") String userName, @Param("password") String password);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}