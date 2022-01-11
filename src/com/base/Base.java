package com.base;

import java.util.regex.Pattern;

/**
 * @author 邓联海
 * @description 测试类
 * @date 2020/7/1 8:58
 */
public class Base {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[A-Za-z0-9-#]+$");

    private void test() {
        System.out.println(NUMBER_PATTERN.matcher("——#111-2-2AAAqqq").matches());

        System.out.println("1212".contains(""));

        String deptCode = "";
        int lenth = 10;
        System.out.println(lenth >> 1);
//        if (Objects.isNull(deptCode)){
//            System.out.println("hello");
//        }
    }

    static public void main(String[] a) {
        new Base().test();
    }
}
