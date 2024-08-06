package com.sky.service.impl;

import com.alibaba.druid.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.sky.constant.MessageConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.exception.LoginFailedException;
import com.sky.mapper.UserMapper;
import com.sky.properties.WeChatProperties;
import com.sky.service.UserService;
import com.sky.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service.impl
 * @fileName UserServiceImpl.java
 * @createTime 2024/8/6
 * @copyright 2024 Amarsoft
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    //微信服务接口地址
    public static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private WeChatProperties weChatProperties;

    @Autowired
    private UserMapper userMapper;

    /**
     * 微信登录
     *
     * @param userLoginDTO
     * @return
     */
    @Override
    public User wxLogin(UserLoginDTO userLoginDTO) {
        String openId = getOpenId(userLoginDTO.getCode());
        //判断openid是否为空，如果为空表示登录失败，抛出业务异常
        if (openId == null) {
            throw new LoginFailedException(MessageConstant.LOGIN_FAILED);

        }
        //判断是否是新用户
        User user = userMapper.getByOpenid(openId);
        if (user == null) {
            //新用户，自动完成注册
            user = User.builder()
                    .openid(openId)
                    .build();
            userMapper.insert(user);
        }
        return user;
    }


    private String getOpenId(String code) {
        //调用微信服务接口
        Map<String, String> map = new HashMap<>();
        map.put("appid", weChatProperties.getAppid());
        map.put("secret", weChatProperties.getSecret());
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String result = HttpClientUtil.doGet(WX_LOGIN, map);
        JSONObject jsonObject = JSON.parseObject(result);
        String openid = jsonObject.getString("openid");
        return openid;
    }
}