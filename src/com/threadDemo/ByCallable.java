package com.threadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过callable 和 futureTask方法来实现线程
 */
public class ByCallable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Object> callable = new Ticket<Object>();
        FutureTask<Object> futureTask = new FutureTask<Object>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        // 通过FutureTask对象来获取线程执行结束后返回的值
        System.out.println(futureTask.get().toString());
    }
}

class Ticket<object> implements Callable<object>{

    @Override
    public object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return (object) "线程跑起来了";
    }
}
