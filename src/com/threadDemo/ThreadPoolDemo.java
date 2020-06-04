package com.threadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description 手动创建线程池
 * @author 邓联海
 * @date 2020/6/4 16:32
 */
public class ThreadPoolDemo {
    private   static int   count=0;
    private final  static int   threadNum=100;
    private final  static int   times=1000000;
    private static void inc(){
        count++;
    }
    public static void main(String[] args) {
        List<Thread> ts=new ArrayList<Thread>();
        for (int i = 0; i < threadNum; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    for (int j = 0; j < times; j++) {
                        ThreadPoolDemo.inc();
                    }
                }
            });
            ts.add(t);
        }
        long time=System.currentTimeMillis();
        for (Thread t:ts) {
            t.start();
        }
        while (true) {
            int num = 0;
            for (Thread t : ts) {
                if(t.isAlive()) {
                    num++;
                }
            }
            if(num==0) {
                break;
            }
            System.out.println("live thread :" +num);
            sleep(1000);
        }
        System.out.println("costTime:"+(System.currentTimeMillis()-time));
        System.out.println("you want num is " +(times*threadNum));
        System.out.println("the real num is " +(count));
    }

    private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
