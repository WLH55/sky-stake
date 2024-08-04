package com.sky.controller.admin;

import com.sky.constant.RedisConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.controller.admin
 * @fileName ShopController.java
 * @createTime 2024/8/4
 * @copyright 2024 Amarsoft
 */

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PutMapping("/{status}")
    @ApiOperation("修改店铺营业状态")
    public Result<?> setStatus(@PathVariable Integer status) {
        log.info("修改店铺营业状态为：{}", status);
        redisTemplate.opsForValue().set(RedisConstant.key, status.toString());
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus(){

        // 读取值时将其转换为 Integer
        String statusStr = (String) redisTemplate.opsForValue().get(RedisConstant.key);
        Integer status = Integer.valueOf(statusStr);
        log.info("获取店铺营业状态为：{}", status == 1? "营业中" : "休息中");
        return Result.success(status);


    }




}