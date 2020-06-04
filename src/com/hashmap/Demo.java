package com.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 邓联海
 * @description
 * @date 2020/3/20 17:28
 */
public class Demo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        //多线程验证HashMap的线程安全性
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            int finalI1 = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Double e = Math.random();
                    map.put(finalI, finalI1);
                }
            }).start();
        }

        System.out.println("HashMap size:"+map.size());

        //多线程测试ConcurrentHashMap的线程安全性
        ConcurrentHashMap<Integer, AtomicInteger> concurrentHashMap = new ConcurrentHashMap<>(16);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            AtomicInteger finalI2 = new AtomicInteger(i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    concurrentHashMap.put(finalI, finalI2);
                }
            }).start();
        }
        System.out.println("ConcurrentHashMap:" + concurrentHashMap.size());


    }

    /**
     * hashMap中取一个大于该长度且最小的2的指数次幂
     * 初始化hash的初始容量
     *
     * @param cap
     * @return
     */
    private static int testTableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
