package com.io.reactor;

/**
 * @description accept 事件处理器
 * @Date 2022/1/19 10:06
 * @Created by lianhai.deng
 */

public class AcceptEventHandler extends EventHandler{

    private Selector selector;

    public AcceptEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType() == EventType.ACCEPT){
            Event readEvent = new Event();
            readEvent.setInput(event.getInput());
            readEvent.setEventType(EventType.READ);

            selector.addEvent(readEvent);
        }
    }
}
