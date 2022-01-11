package com.clone;

/**
 * @Author 邓联海
 * @Description 对象拷贝
 * @Date 2022/1/11 17:31
 **/
public class ObjectCopy {

    public static void main(String[] args) throws CloneNotSupportedException{
        Teacher teacher = new Teacher("dlh", 20);
        Teacher teacherCopy = (Teacher) teacher.clone();
        System.out.println(teacher);
        System.out.println(teacherCopy);
    }
}