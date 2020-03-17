package com.threadDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建线程
 */
public class ThreadPool {

    private static Integer POOL_NUM = 5;

    public static void main(String[] args) {
        // 第一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_NUM);
        // 第二个线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(POOL_NUM);
        for (int i = 0; i< POOL_NUM; i++){
            RunnableThread thread = new RunnableThread();
            // 执行线程
            executorService1.execute(thread);
            // 执行线程
            executorService.execute(thread);
        }
    }
}

class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("当前执行的线程是："+Thread.currentThread().getName());
    }
}
