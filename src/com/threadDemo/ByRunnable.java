package com.threadDemo;

/**
 * 通过重写 runnable 来实现 线程
 */
public class ByRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class myThread{
    public static void main(String[] args){
        Thread thread = new Thread(new ByRunnable());
        thread.setName("xx_1");
        thread.start();
    }
}
