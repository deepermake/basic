package com.problems.easy;

/**
 * 1446 - 连续字符
 */
public class MaxPower {

    public static void main(String[] args) {
        // System.out.println(maxPower("aaabbbcccddeeeee"));
        System.out.println(maxPower("leetcode"));
    }

    public static int maxPower(String s) {
        int i = 0, j = 1, res = 1;
        while (i < j && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                res = Math.max(j - i + 1, res);
                j++;
                continue;
            }
            i = j;
            j++;
        }
        return res;

    }
}
