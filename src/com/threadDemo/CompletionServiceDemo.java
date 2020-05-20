package com.threadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description CompletionService 用法
 * @author 邓联海
 * @date 2020/5/20 13:21
 */
public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService EXECUTOR_THREAD_POOL = new ThreadPoolExecutor(0, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10000));
        CompletionService completionService = new ExecutorCompletionService(EXECUTOR_THREAD_POOL);
        for (int i = 0; i< 10; i++){
            int finalI = i;
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    return testReturn(finalI);
                }
            });
        }
        for (int i=0; i<10; i++){
            System.out.println(completionService.take().get());
        }
    }

    public static String testReturn(int i){
        return String.valueOf(i)+":执行了";
    }
}
