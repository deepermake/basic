package com.proxy.dynamicProxy;

import com.proxy.staticProxy.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandle implements InvocationHandler {

    Star realStar;

    public StarHandle(Star realStar) {
        super();
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        if (method.getName().equals("sing")){
            object = method.invoke(realStar, args);
        }
        return  object;
    }
}
