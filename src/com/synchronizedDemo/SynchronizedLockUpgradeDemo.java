package com.synchronizedDemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lianhai.deng
 * @description synchronized锁升级过程追踪
 * @createTime 2022/5/13 17:02
 */
public class SynchronizedLockUpgradeDemo {
    public static void main(String[] args) throws InterruptedException {
        C c = new C();
        ClassLayout classLayout = ClassLayout.parseInstance(c);
        System.out.println("初始化，s对象头信息：");
        System.out.println(classLayout.toPrintable());

        synchronized (c) {
            System.out.println("获取锁， s对象头");
            System.out.println(classLayout.toPrintable());
        }

        Thread t = new Thread(() -> {
            synchronized (c) {
                System.out.println("t线程获取锁后，s对象头：");
                System.out.println(classLayout.toPrintable());
            }
        });
        t.start();
        t.join();

        Thread t2 = new Thread(() -> {
            synchronized (c) {
                System.out.println("t2线程获取锁后，s对象头：");
                System.out.println(classLayout.toPrintable());
            }
        });
        t2.start();


    }

    public static class C {
    }
}
