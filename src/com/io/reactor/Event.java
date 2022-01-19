package com.io.reactor;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @description reactor模式中内部处理的event类
 * @Date 2022/1/19 10:01
 * @Created by lianhai.deng
 */

public class Event {

    private InputSource input;

    private EventType eventType;

    public InputSource getInput() {
        return input;
    }

    public void setInput(InputSource input) {
        this.input = input;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "input=" + input +
                ", eventType=" + eventType +
                '}';
    }
}
