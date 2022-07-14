package com.designPatterns.single;

/**
 * Description: 单例模式 - 枚举
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/7/14 17:56
 */
public enum SingletonEnum {

    INSTANCE;

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}
