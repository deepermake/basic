package com.designPatterns.fatory;

/**
 * 具体的HtmlFactory工厂类
 * @author admin
 */
public class HtmlFactory extends Factory {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
