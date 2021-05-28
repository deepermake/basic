package com.designPatterns.fatory;

/**
 *
 * @description 通用工厂类
 * @author 邓联海 lianhai.deng@luckincoffee.com
 * @date 2021/4/28 13:51
 */
public abstract class Factory {
    /**
     * 通用创建Button方法
     * @return Button
     */
    public abstract Button createButton();
}
