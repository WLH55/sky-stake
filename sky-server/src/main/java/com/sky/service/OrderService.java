package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.Result;
import com.sky.vo.OrderSubmitVO;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service
 * @fileName OrderService.java
 * @createTime 2024/8/10
 * @copyright 2024 Amarsoft
 */
public interface OrderService {


    OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO);
}