package com.designPatterns.single;

/**
 * Description: 单例模式 - 懒汉模式
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/7/14 18:08
 */
public class SingletonLazyMan {

    private SingletonLazyMan() {
    }

    private static volatile SingletonLazyMan instance = null;

    public SingletonLazyMan getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyMan.class){
                if (instance == null){
                    instance = new SingletonLazyMan();
                }
            }
        }
        return instance;
    }
}
