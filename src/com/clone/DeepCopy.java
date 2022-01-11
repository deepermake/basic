package com.clone;

/**
 * @Author 邓联海
 * @Description 深拷贝
 * @Date 2022/1/11 17:54
 **/
public class DeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException{
        Teacher teacher = new Teacher("dlh teacher", 20);
        Student student = new Student();
        student.setTeacher(teacher);

        Student studentCopy = (Student) student.deepClone();

        studentCopy.getTeacher().setName("clone dlh teacher");

        System.out.println("本体:" + student + "   本体指向teacher:"+student.getTeacher()+"  本体指向的 teacher name:"+student.getTeacher().getName());
        System.out.println("克隆体:"+ studentCopy + "   克隆体指向teacher:"+studentCopy.getTeacher()+"  克隆体指向的teacher name:"+studentCopy.getTeacher().getName());
    }

}
