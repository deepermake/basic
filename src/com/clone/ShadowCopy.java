package com.clone;

/**
 * @Author 邓联海
 * @Description 浅拷贝
 * @Date 2022/1/11 17:15
 **/
public class ShadowCopy {

    public static void main(String[] args) throws CloneNotSupportedException{

        Teacher teacher = new Teacher("dlh", 20);

        Student student = new Student();
        student.setTeacher(teacher);

        Student studentCopy = (Student) student.clone();
        studentCopy.getTeacher().setName("copy");

        System.out.println("本体student：" + student + "   本体指向teacher " + student.getTeacher() + "    本体指向的teacher name:"+ student.getTeacher().getName());
        System.out.println("克隆体student：" + studentCopy + " 克隆体指向的teacher " + studentCopy.getTeacher() + " 克隆体指向的teacher name:" + studentCopy.getTeacher().getName());
    }
}
