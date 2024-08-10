package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.mapper.ShoppingCartMapper;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service.impl
 * @fileName ShoppingCartServiceImpl.java
 * @createTime 2024/8/8
 * @copyright 2024 Amarsoft
 */
@Service
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO,shoppingCart);
        Long userId = BaseContext.getCurrentId();
        shoppingCart.setUserId(userId);
        //判断购物车是否已经存在
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);
        if(list != null && list.size() == 1){
            shoppingCart = list.get(0);
            shoppingCart.setNumber(list.get(0).getNumber() + 1);
            shoppingCartMapper.updateNumberById(shoppingCart);
        }else{
            //判断是菜品还是套餐
            Long dishId = shoppingCart.getDishId();
            if(dishId != null){
                Dish dish = dishMapper.getById(dishId);
                shoppingCart.setAmount(dish.getPrice());
                shoppingCart.setImage(dish.getImage());
                shoppingCart.setName(dish.getName());
            }else{
                Setmeal setmeal = setmealMapper.getById(shoppingCart.getSetmealId());
                shoppingCart.setAmount(setmeal.getPrice());
                shoppingCart.setImage(setmeal.getImage());
                shoppingCart.setName(setmeal.getName());

            }
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartMapper.insert(shoppingCart);
        }






    }

    /**
     * 查看购物车
     * @return
     */
    public List<ShoppingCart> showShoppingCart() {
        return shoppingCartMapper.list(ShoppingCart.
                builder().
                userId(BaseContext.getCurrentId()).
                build());
    }

    /**
     * 清空购物车商品
     */
    public void cleanShoppingCart() {
        shoppingCartMapper.deleteByUserId(BaseContext.getCurrentId());
    }

    /**
     * 减少购物车商品
     * @param shoppingCartDTO
     */

    @Override
    public void subShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO,shoppingCart);
        shoppingCart.setUserId(BaseContext.getCurrentId());
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);

        if(list != null && list.size() == 1){
            shoppingCart = list.get(0);
            shoppingCart.setNumber(shoppingCart.getNumber() - 1);
            shoppingCartMapper.updateNumberById(shoppingCart);
        }

    }
}