package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <此处编写类相关描述
 *
 * @author CWL
 * @version 1.0
 * @packageName com.sky.annotation
 * @fileName AutoFill.java
 * @createTime 2024/7/7
 * @copyright 2024 WQX
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    /**
     * 数据库操作类型，update,insert
     * @return
     */
    OperationType value();
}
