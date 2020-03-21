package com.threadDemo;

/**
 * 通过继承Thread,实现线程
 */
public class ByThread extends Thread {

    public ByThread(){}

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){
        ByThread byThread = new ByThread();
        byThread.setName("线程一号");
        byThread.start();
    }
}
