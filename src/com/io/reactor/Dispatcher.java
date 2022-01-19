package com.io.reactor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 事件分发器
 * @Date 2022/1/19 10:35
 * @Created by lianhai.deng
 */

public class Dispatcher {
    Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();

    Selector selector;

    Dispatcher(Selector selector){
        this.selector = selector;
    }

    public void registerEventHandler(EventType eventType, EventHandler eventHandler){
        eventHandlerMap.put(eventType, eventHandler);
    }

    public void removeEventHandler(EventType eventType){
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents(){
        dispatch();
    }

    /**
     * 分发
     */
    private void dispatch(){
        // while遍历，不断轮询从队列中获取需要处理的事件
        while (true){
            List<Event> events = selector.select();
            for (Event event: events){
                // 从map中获取对应类型的事件处理handler
                EventHandler eventHandler = eventHandlerMap.get(event.getEventType());
                // 处理事件
                eventHandler.handle(event);
            }
        }
    }
}
