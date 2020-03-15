package com.dlh;

/**
 *
 * @description 个人信息测试类
 * @author 邓联海
 * @date 2020/3/13 9:21
 */
@StuAnnotation(value = "t_student")
public class Student {

    @StuAnnotation(value = "name", type = "varchar", length = 10)
    private String name;

    @StuAnnotation(value = "age", type = "int", length = 3)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 无参构造器
    public Student(){}

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
