package com.synchronizedDemo;

public class SynchronizedTest {

    public static final String str = "hello";


    public static void main(String[] args) {
        synchronized (str) {
            System.out.printf(str);
        }
    }
}
