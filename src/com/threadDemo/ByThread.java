package com.threadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过继承Thread,实现线程
 */
public class ByThread extends Thread {

    static volatile int count = 0;

    public ByThread(){}

    @Override
    public synchronized void run() {
        count = count + 1;
    }

    public static void main(String[] args){
        for (int i = 0 ;i < 100 ;i++){
            ByThread thread = new ByThread();
            thread.start();
        }

        System.out.println(count);
    }
}
