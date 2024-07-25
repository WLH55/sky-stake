package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <此处编写类相关描述
 *
 * @author CWL
 * @version 1.0
 * @packageName com.sky.mapper
 * @fileName SetmealDishMapper.java
 * @createTime 2024/7/24
 * @copyright 2024 WQX
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
     *
     * @param dishIds
     * @return
     */
    //select setmeal_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}
