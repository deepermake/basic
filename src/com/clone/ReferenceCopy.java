package com.clone;

/**
 * @Author 邓联海
 * @Description 引用拷贝
 * @Date 2022/1/11 17:16
 **/
public class ReferenceCopy {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("dlh", 20);
        Teacher teacherCopy = teacher;
        System.out.println(teacher);
        System.out.println(teacherCopy);
    }
}

