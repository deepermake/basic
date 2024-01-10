//package com.synchronizedDemo;
//
//import org.openjdk.jol.info.ClassLayout;
//
///**
// * @author lianhai.deng
// * @description synchronized锁升级过程追踪
// * @createTime 2022/5/13 17:02
// */
//public class SynchronizedLockUpgradeDemo {
//    static C c = new C();
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ClassLayout classLayout = ClassLayout.parseInstance(c);
//        System.out.println("初始化，======== 无锁 ========");
//        System.out.println(classLayout.toPrintable());
//
//        // 需要通过 -XX:BiasedLockingStartupDelay=0 偏向锁延时=0，JVM默认为4s
//        new Thread(new C()).start();
//        System.out.println("初始化，======== 偏向锁 ========");
//        System.out.println(classLayout.toPrintable());
//
//        new Thread(new C()).start();
//        System.out.println("初始化，======== 轻量级锁 ========");
//        System.out.println(classLayout.toPrintable());
//
//        for (int i = 0; i<100; i++){
//            new Thread(new C()).start();
//        }
//        System.out.println("初始化，======== 重量级锁 ========");
//        System.out.println(classLayout.toPrintable());
//
//        Thread.sleep(10000);
//        System.out.println("======= 释放锁 ========");
//        System.out.println(classLayout.toPrintable());
//
//    }
//
//    public static class C implements Runnable {
//        @Override
//        public void run() {
//            synchronized (c) {
//                String test = "";
//                for (int i = 0; i < 1000; i++) {
//                    test = test.concat(String.valueOf(i));
//                }
//            }
//        }
//    }
//}
