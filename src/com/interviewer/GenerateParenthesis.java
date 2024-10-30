package com.interviewer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09 括号
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(5));
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
    }


    /**
     * 解题思路
     * n个（）
     * 1、第1个字符为“（”
     * 2、第n-1个字符为“）”
     * 3、“（”的个数为n，“）”的个数为n
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        backTrack(list, n, "(");
        return list;

    }


    public static void backTrack(List<String> list, int k, String s) {
        if (s.length() == 2 * k) {
            list.add(s);
        }
        for (int i = s.length() - 1; i < 2 * k + 1; i++) {
            if (valid(s, k)) {
                s = s.concat(")");
                backTrack(list, k, s);
                s = s.substring(0, s.length() - 1).concat("(");
            }
        }
    }

    /**
     * 判断是否可以放置“）”
     * 1、“(”的数量需要大于或等于“)”
     * 2、“(” or ")" 的数量需要小于等于n
     * 3、“(” + ")"的数量需要小于2n-1
     *
     * @param s
     */
    public static boolean valid(String s, int k) {
        int l = 1, r = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
        }
        return l >= r && l <= k;
    }

}
