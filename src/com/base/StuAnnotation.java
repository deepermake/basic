package com.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 邓联海
 * 个人信息注解类
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface StuAnnotation {
    String value() default "";
    int length() default 3;
    String type() default "varchar";
}
