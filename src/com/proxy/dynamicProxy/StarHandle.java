package com.proxy.dynamicProxy;

import com.proxy.staticProxy.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandle implements InvocationHandler {

    Star realStar;

    public StarHandle(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        // 动态代理的核心都是调用 invoke方法去执行类方法
        object = method.invoke(realStar, args);
        return  object;
    }
}
