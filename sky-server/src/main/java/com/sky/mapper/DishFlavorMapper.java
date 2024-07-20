package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <此处编写类相关描述
 *
 * @author CWL
 * @version 1.0
 * @packageName com.sky.mapper
 * @fileName DishFlavorMapper.java
 * @createTime 2024/7/21
 * @copyright 2024 WQX
 */
@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}
