package com.synchronizedDemo;

/**
 * @author 邓联海
 * @description 测试synchronized关键字的功能
 * @date 2020/6/6 16:59
 */
public class SynchronizedDemo {

    /**
     * 修饰静态类
     *
     * @param threadName
     * @throws InterruptedException
     */
    public synchronized static void print(String threadName) throws InterruptedException {

        System.out.println(threadName + " print 开始");
        Thread.sleep(2000);
        System.out.println(threadName + " print 结束");
    }

    /**
     * 修饰普通方法
     *
     * @param threadName
     * @throws InterruptedException
     */
    public synchronized void print2(String threadName) throws InterruptedException {
        System.out.println(threadName + " print2 开始");
        Thread.sleep(2000);
        System.out.println(threadName + " print2 结束");
    }

    /**
     * 修饰代码块
     *
     * @param object
     * @throws InterruptedException
     */
    public void printMethod(Object object) throws InterruptedException {
        synchronized (object) {
            System.out.println(object + " printMethod 开始");
            Thread.sleep(2000);
            System.out.println(object + " printMethod 结束");
        }
    }

}
