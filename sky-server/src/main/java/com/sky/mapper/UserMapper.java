package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.mapper
 * @fileName UserMapper.java
 * @createTime 2024/8/6
 * @copyright 2024 Amarsoft
 */

@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 插入数据
     * @param user
     */
    void insert(User user);

    /**
     * 根据id查询用户
     */
    @Select("select * from user where id = #{id}")
    User getById(Long id);
}