//package com.sky.config;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @author CWL
// * @version 1.0
// * @Description
// * @packageName com.sky.config
// * @fileName RedisConfigurationTest.java
// * @createTime 2024/8/4
// * @copyright 2024 WQX
// */
//@SpringBootTest
//class RedisConfigurationTest {
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    void redisTemplate() {
//
//    }
//
//    /**
//     * 操作字符串类型的数据
//     */
//    @Test
//    public void testString(){
//        // set get setex setnx
//        redisTemplate.opsForValue().set("name","小明");
//        String city = (String) redisTemplate.opsForValue().get("name");
//        System.out.println(city);
//        redisTemplate.opsForValue().set("文千喜","18",4,TimeUnit.MINUTES);
//        redisTemplate.opsForValue().set("code","1234",3, TimeUnit.MINUTES);
//        redisTemplate.opsForValue().setIfAbsent("lock","1");
//        redisTemplate.opsForValue().setIfAbsent("lock","2");
//    }
//}