package com.newFeaturesJDK18;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @description jdk1.8新特性filter
 * @author 邓联海
 * @date 2020/5/20 10:32
 */
public class FilterDemo {


    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        String a = "aaaaa";
        String a1 = "bbbbb";
        String a2 = "ccccc";
        String a3 = "ddddd";
        lists.add(a);
        lists.add(a1);
        lists.add(a2);
        lists.add(a3);
        lists.stream().filter(item -> item.contains("aaa"));
    }
}
