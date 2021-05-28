package com.designPatterns.fatory;

/**
 *
 * @description 具体的WindowsFactory工厂类
 * @author 邓联海 lianhai.deng@luckincoffee.com
 * @date 2021/4/28 13:57
 */
public class WindowsFactory extends Factory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
