package com.threadDemo;

import com.base.SynchronizedDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过继承Thread,实现线程
 */
public class ByThread extends Thread {

    static volatile int count = 0;

    SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

    public ByThread(){}

    @Override
    public void run() {
        // count = count + 1;
        // synchronizedDemo.print2(super.getName());
        SynchronizedDemo.print(super.getName());

    }

    public static void main(String[] args){
            ByThread thread = new ByThread();
            thread.setName("线程AA");
            ByThread thread1 = new ByThread();
            thread1.setName("线程BB");
            thread.start();
            thread1.start();

        //System.out.println(count);
    }
}
