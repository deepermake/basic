package com.designPatterns.fatory;

import javax.swing.*;

/**
 * client
 * @author admin
 */
public class Application {

    static Factory factory;

    public static void main(String[] args) {
        config();
        runButton();
    }

    public static void config(){
        if (("windows").equals(System.getProperty("os.name"))){
            factory = new WindowsFactory();
        }else {
            factory = new HtmlFactory();
        }
    }

    public static void runButton(){
        factory.createButton().onClick();
    }
}
