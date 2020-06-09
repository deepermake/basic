package com.threadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description 线程池工具类
 * @author 邓联海
 * @date 2020/6/9 15:52
 */
public class ThreadPoolUtils {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1000));
}
