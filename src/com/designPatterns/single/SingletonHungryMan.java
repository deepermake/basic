package com.designPatterns.single;

/**
 * Description: 单例模式 - 饿汉模式
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/7/14 17:56
 */
public class SingletonHungryMan {

    // 1、防止外部直接new 对象破坏单例模式
    private SingletonHungryMan() {
    }
    // 2、通过私有变量保存单例对象
    private static SingletonHungryMan instance = new SingletonHungryMan();
    // 3、提供公共获取单例对象的方法
    public static SingletonHungryMan getInstance() {
        return instance;
    }
}
