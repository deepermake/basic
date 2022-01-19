package com.io.reactor;

/**
 * @description
 * @Date 2022/1/19 10:34
 * @Created by lianhai.deng
 */

public class Server {

    Selector selector = new Selector();
    Dispatcher dispatcher = new Dispatcher(selector);
    Acceptor acceptor;

    Server(int port){
        acceptor = new Acceptor(selector, port);
    }

    public void start(){
        dispatcher.registerEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-"+acceptor.getPort()).start();
        dispatcher.handleEvents();
    }
}
