package com.problems.str.easy;

import java.util.Arrays;

/**
 * 344-反转字符串
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] str = new char[]{'a','b','v','d'};
        reverseString(str);
        System.out.println(Arrays.toString(str));
    }

    public static void reverseString(char[] s) {
        int i = 0;
        while (i < s.length / 2) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
            i ++;
        }
    }
}
