package com.dlh;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @description 个人信息测试类
 * @author 邓联海
 * @date 2020/3/13 9:35
 */
public class StudentTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 反射
        Class object = Class.forName("com.dlh.Student");
        // 获取字段
        List<Field> fields = Arrays.asList(object.getDeclaredFields());
        // 获取注解
        StuAnnotation annotation = (StuAnnotation) object.getAnnotation(StuAnnotation.class);
        System.out.println(object.getName()+" annotation info:"+annotation.value()+", "+annotation.type()+", "+annotation.length());

        for (Field field:fields){
            System.out.println(field.getName()+":"+field.getAnnotation(StuAnnotation.class).value());
        }

    }
}
