package com.designPatterns.single;

/**
 * Description: 单例模式 - 静态内部类
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/7/14 18:03
 */
public class SingletonStaticClass {

    // 1、防止外部直接new 对象破坏单例模式
    private SingletonStaticClass() {
    }
    // 2、静态内部类
    private static class SingletonHolder {
        private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
    }
    // 3、提供公共获取单例对象的方法
    public static final SingletonStaticClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
