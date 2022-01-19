package com.io.reactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description
 * @Date 2022/1/19 10:24
 * @Created by lianhai.deng
 */

public class Acceptor implements Runnable{

    private int port;

    private Selector selector;

    private BlockingQueue<InputSource> sourceBlockingQueue = new LinkedBlockingQueue<InputSource>();

    Acceptor(Selector selector, int port){
        this.selector = selector;
        this.port = port;
    }

    public void addNewConnection(InputSource inputSource){
        sourceBlockingQueue.offer(inputSource);
    }

    public int getPort() {
        return port;
    }

    @Override
    public void run() {
        while (true){
            InputSource source = null;
            try {
                source = sourceBlockingQueue.take();
            }catch (InterruptedException e){

            }

            if (source != null){
                Event acceptEvent = new Event();
                acceptEvent.setInput(acceptEvent.getInput());
                acceptEvent.setEventType(EventType.ACCEPT);
                selector.addEvent(acceptEvent);
            }
        }
    }
}
