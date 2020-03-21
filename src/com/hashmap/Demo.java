package com.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @description
 * @author 邓联海
 * @date 2020/3/20 17:28
 */
public class Demo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args){
        int result = testTableSizeFor(11);
        System.out.println(result);

    }

    private static int testTableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
