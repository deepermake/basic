package com.designPatterns.fatory;

/**
 * 另一个具体产品类
 * @author admin
 */
public class WindowsButton implements Button {

    @Override
    public void onClick() {
        System.out.println("this is a windowsButton");
    }
}
