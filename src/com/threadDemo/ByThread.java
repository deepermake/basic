package com.threadDemo;

import com.base.LockDemo;
import com.base.SynchronizedDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过继承Thread,实现线程
 */
public class ByThread extends Thread {

    static volatile int count = 0;

    SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
    LockDemo lockDemo = new LockDemo();
    Lock lock = new ReentrantLock();

    public ByThread(){}

    @Override
    public void run() {
        // count = count + 1;

        // todo: 测试synchronized关键字
        // synchronizedDemo.print2(super.getName());
        // SynchronizedDemo.print(super.getName());

        // todo：测试lock()方法
        try {
            lockDemo.printInfo(super.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        lock.lock();
//        try {
//            for (int i=0; i<10; i++){
//                System.out.println(super.getName()+"正在：【"+i+"】");
//            }
//        }finally {
//            lock.unlock();
//            System.out.println(super.getName()+"释放资源");
//        }

    }

    public static void main(String[] args){
            ByThread thread = new ByThread();
            thread.setName("线程AA");
            ByThread thread1 = new ByThread();
            thread1.setName("线程BB");

            ByThread thread2 = new ByThread();
            thread2.setName("线程CC");
            thread.start();
            thread1.start();
            thread2.start();

            // todo: 线程池
            for (int i = 0; i<10; i++){
                ThreadPoolUtils.threadPoolExecutor.execute(() -> {
                    try {
                        new LockDemo().printInfo(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

        //System.out.println(count);
    }

}
