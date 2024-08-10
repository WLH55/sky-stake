package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.mapper
 * @fileName OrderMapper.java
 * @createTime 2024/8/10
 * @copyright 2024 Amarsoft
 */
@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);
}