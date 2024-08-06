package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.vo.UserLoginVO;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service
 * @fileName UserService.java
 * @createTime 2024/8/6
 * @copyright 2024 Amarsoft
 */
public interface UserService {
    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);




}