package com.io.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description
 * @Date 2022/1/19 10:07
 * @Created by lianhai.deng
 */

public class Selector {
    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();

    private Object lock = new Object();

    List<Event> select(){
        return select(0);
    }

    List<Event> select(long timeout){
        if (timeout > 0){
            if (eventQueue.isEmpty()){
                synchronized (lock){
                    if (eventQueue.isEmpty()){
                        try {
                            lock.wait(timeout);
                        }catch (InterruptedException e){

                        }
                    }
                }
            }
        }
        // 业务处理
        List<Event> events = new ArrayList<Event>();
        eventQueue.drainTo(events);
        return events;
    }

    public void addEvent(Event event){
        // 将event事件加入队列
        boolean success = eventQueue.offer(event);
        if (success){
            synchronized (lock){
                // 如果有新增事件则对lock对象解锁
                lock.notify();
            }
        }
    }
}
