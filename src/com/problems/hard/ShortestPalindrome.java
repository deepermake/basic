package com.problems.hard;

import java.util.Objects;

/**
 * 214 - 最短回文串
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("ababbaba"));
        System.out.println(shortestPalindrome("abcd"));
        System.out.println(shortestPalindrome(""));
        System.out.println(shortestPalindrome("ab"));
        System.out.println(shortestPalindrome("aa"));
        System.out.println(shortestPalindrome("aba"));

    }

    public static String shortestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        int index = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(0) != s.charAt(i - 1)) {
                continue;
            }
            if (i == 2) {
                index = 2;
                continue;
            }
            // 比较两个字符串是否相等，如果相等则是回文子串
            String half = s.substring((i / 2) + 1, i);
            if (i % 2 == 0) {
                half = s.substring(i / 2, i);
            }
            StringBuilder str = new StringBuilder(half);
            if (Objects.equals(s.substring(0, i / 2), str.reverse().toString())) {
                index = i;
            }
        }
        if (index == s.length()) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s.substring(index));
        s = s.substring(0, index).concat(stringBuilder.toString());
        return stringBuilder.reverse().toString().concat(s);
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
