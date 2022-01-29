package com.threadDemo;

/**
 *
 * @description threadLocal测试类
 * @author 邓联海
 * @date 2020/6/9 17:50
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        retry:
        for (;;){
            for (int i =0 ;i<5; i++){
                System.out.println(i);
                if (i ==4 ){
                    break retry;
                }
            }
        }
    }
}
