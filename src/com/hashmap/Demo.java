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

        Map<String, Integer> map = new HashMap<>();
        map.put("ZhangYi",98);
        map.put("WangEr",99);
        map.put("ZhangShan",89);
        map.put("Lisi",92);


        int result = testTableSizeFor(11);
        System.out.println(result);

    }

    /**
     * hashMap中取一个大于该长度且最小的2的指数次幂
     * @param cap
     * @return
     */
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
