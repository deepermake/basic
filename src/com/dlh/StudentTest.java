package com.dlh;

import java.lang.reflect.Constructor;
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
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
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

        // 通过反射获取无参构造器
        Student stu2 = (Student) object.newInstance();

        // 通过反射获取有参构造器
        Constructor<Student> s = object.getConstructor(String.class, int.class);
        Student stu = s.newInstance("dlh2", 26);
        System.out.println(stu.toString());

        // 通过反射来操作属性
        Field f = object.getDeclaredField("age");
        // 访问私有属性/变量
        f.setAccessible(true);
        f.set(stu2, 27);
        System.out.println("方法1：stu2.age = "+f.get(stu2));
        System.out.println("方法2：stu2.age = "+stu2.getAge());

    }
}
