package com.interviewer;

/**
 * 面试题 01.09 字符串轮转
 */
public class IsFlipedString {

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString("ab", "ba"));
        System.out.println(isFlipedString("ab", "ab"));
        System.out.println(isFlipedString("a", "a"));
        System.out.println(isFlipedString("ab", "aa"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }

}
