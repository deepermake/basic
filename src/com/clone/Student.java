package com.clone;

import java.util.Objects;

/**
 * @Auther: 邓联海
 * @Date: 2022/1/11 17
 * @Description: 学生类
 */
public class Student implements Cloneable{
    /**
     * 姓名
     */
    private String name;

    /**
     * 姓名
     */
    private Integer age;

    /**
     * 老师
     */
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * 普通拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    public Object deepClone() throws CloneNotSupportedException{
        Student student = (Student) super.clone();
        Teacher teacher = (Teacher) student.getTeacher().clone();
        student.setTeacher(teacher);
        return student;
    }
}
