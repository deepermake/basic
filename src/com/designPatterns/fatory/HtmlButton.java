package com.designPatterns.fatory;

/**
 * 具体产品类
 * @author admin
 */
public class HtmlButton implements Button{

    @Override
    public void onClick() {
        System.out.println("this is is a htmlButton");
    }
}
