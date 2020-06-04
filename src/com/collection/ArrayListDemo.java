package com.collection;

import java.util.ArrayList;

/**
 *
 * @description arrayList 线程安全 以及 扩容机制
 * @author 邓联海
 * @date 2020/6/1 9:15
 */
public class ArrayListDemo {

    public static void main(String[] args){
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        System.out.println(arrayList.size());
    }
}
