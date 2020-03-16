package com.proxy.dynamicProxy;

import com.proxy.staticProxy.RealStar;
import com.proxy.staticProxy.Star;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args){
        Star realStar = new RealStar();
        StarHandle starHandle = new StarHandle(realStar);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, starHandle);
        proxy.sing();
        proxy.collectMoney();
    }
}
