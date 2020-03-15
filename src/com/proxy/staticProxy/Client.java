package com.proxy.staticProxy;

/**
 * 客户类
 */
public class Client {
    public static void main(String[] args){
        Star star = new RealStar();
        Proxy proxy = new Proxy(star);
        proxy.law();
        proxy.sing();
    }
}
