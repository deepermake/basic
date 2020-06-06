package com.base;

/**
 *
 * @description 测试synchronized关键字的功能
 * @author 邓联海
 * @date 2020/6/6 16:59
 */
public class SynchronizedDemo {

    public synchronized static void print(String threadName){
        for (int i=0; i<1000 ;i++){
            System.out.println(i+"当前调用的是线程"+threadName);
        }
    }

    public synchronized void print2(String threadName){
        for (int i=0; i<1000 ;i++){
            System.out.println(i+"当前调用的是线程"+threadName);
        }
    }

}
