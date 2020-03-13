package com.dlh;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @description 个人信息测试类
 * @author 邓联海
 * @date 2020/3/13 9:35
 */
public class StudentTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        // 反射
        Class object = Class.forName("com.dlh.Student");
        // 获取类字段
        List<Field> fields = Arrays.asList(object.getDeclaredFields());
        // 获取类方法
        List<Method> methods = Arrays.asList(object.getDeclaredMethods());
        // 获取注解
        StuAnnotation annotation = (StuAnnotation) object.getAnnotation(StuAnnotation.class);
        System.out.println(object.getName()+" annotation info:"+annotation.value()+", "+annotation.type()+", "+annotation.length());

        // 解析字段注解
        for (Field field:fields){
            System.out.println(field.getName()+":"+field.getAnnotation(StuAnnotation.class).value());
        }
        // 解析方法
        for (Method method: methods){
            if (method.getParameters().length > 0 && method.getName().contains("set") && method.getName().contains("Name")){
                method.invoke(student, "邓联海");
            }
        }
        System.out.println(student.toString());

    }
}
