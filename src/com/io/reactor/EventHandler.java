package com.io.reactor;

/**
 * @description 事件处理的抽象类
 * @Date 2022/1/19 10:04
 * @Created by lianhai.deng
 */

public abstract class EventHandler {

    private InputSource input;

    public abstract void handle(Event event);

    public InputSource getInput() {
        return input;
    }

    public void setInput(InputSource input) {
        this.input = input;
    }
}
