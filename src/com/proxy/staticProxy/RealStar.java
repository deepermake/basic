package com.proxy.staticProxy;

public class RealStar implements Star{

    @Override
    public void law() {
        System.out.println("处理法律事务！");
    }

    @Override
    public void collectMoney() {
        System.out.println("收钱");
    }

    @Override
    public void sing() {
        System.out.println("周杰伦唱歌！！！");
    }
}
