package com.hashmap;

import java.util.HashMap;

/**
 *
 * @description HashMap测试demo
 * @author 邓联海
 * @date 2020/6/1 14:25
 */
public class HashMapTest {
    public static void main(String[] args){

        HashMap hashMap = new HashMap(16);
        hashMap.put("12121", "1212121");
        System.out.println(hashMap.size());
    }
}
