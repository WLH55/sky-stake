package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service
 * @fileName ShoppingCartService.java
 * @createTime 2024/8/8
 * @copyright 2024 Amarsoft
 */
public interface ShoppingCartService {


    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCart> showShoppingCart();

    void cleanShoppingCart();
}