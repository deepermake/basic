package com.proxy.staticProxy;

/**
 * 代理类
 */
public class Proxy implements Star{

    private Star star;

    public Proxy(Star star) {
        this.star = star;
    }


    @Override
    public void law() {
        System.out.println("帮忙明星处理法律事务");
    }

    @Override
    public void collectMoney() {
        System.out.println("帮忙明星收钱");
    }

    @Override
    public void sing() {
        star.sing();
    }
}
