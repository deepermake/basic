package com.synchronizedDemo;

/**
 * @author lianhai.deng
 * @description TODO
 * @createTime 2022/5/10 17:39
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        try {
            synchronizedDemo.print2(super.getName());
            // SynchronizedDemo.print(super.getName());
            // synchronizedDemo.printMethod(super.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            MyThread thread = new MyThread();
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
