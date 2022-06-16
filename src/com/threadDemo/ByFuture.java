package com.threadDemo;

import java.util.concurrent.*;

/**
 * Description:
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/6/15 14:45
 */
public class ByFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "ByFuture task call";
            }
        });

        System.out.println(future.get());
        executorService.shutdown();
    }
}
