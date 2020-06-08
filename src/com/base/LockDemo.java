package com.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @description Lock() 方法
 * @author 邓联海
 * @date 2020/6/8 10:44
 */
public class LockDemo {
    private static Lock lock = new ReentrantLock();

    public void printInfo(String name) throws InterruptedException {
        if (lock.tryLock(3, TimeUnit.MILLISECONDS)){
            try {
                for (int i=0; i< 10; i++){
                    System.out.println(name+" 跑了["+ i +"]");
                }
            }finally {
                lock.unlock();
                System.out.println(name+"释放锁");
            }
        }else {
            System.out.println(name+"请求资源，资源正在被占用！");
        }

    }
}
