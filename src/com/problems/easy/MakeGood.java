package com.problems.easy;

/**
 * 1544 - 整理字符串
 */
public class MakeGood {

    public static void main(String[] args) {
        // System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("EeAaCc"));
        // System.out.println(makeGood("s"));
    }

    public static String makeGood(String s) {
        int i = 1;
        StringBuilder sb = new StringBuilder(s);
        while (i < sb.length()) {
            int a = Math.abs(sb.charAt(i) - sb.charAt(i - 1));
            if (a != 32) {
                i++;
                continue;
            }
            sb = sb.replace(i - 1, i + 1, "");
            if (i > 1) {
                i--;
            }
        }
        return sb.toString();
    }
}
