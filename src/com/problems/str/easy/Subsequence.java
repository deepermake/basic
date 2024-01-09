package com.problems.str.easy;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class Subsequence {
    public static void main(String[] args) {
        //System.out.println(isSubsequence("abc", "ahbgdc"));
        //System.out.println(isSubsequence("abcd", "ahbgdc"));
        //System.out.println(isSubsequence("", "ahbgdc"));
        //System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequenceByTwoPointers("axc", "ahbgdc"));
        System.out.println(isSubsequenceByTwoPointers("abcd", "ahbgdc"));
        System.out.println(isSubsequenceByTwoPointers("aab", "arerasdb"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (t.indexOf(s.charAt(i)) == -1) {
                return false;
            }
            t = t.substring(t.indexOf(s.charAt(i)) + 1);
        }
        return true;
    }

    /**
     * 双指针解法
     *
     * @return
     */
    public static boolean isSubsequenceByTwoPointers(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i - 1 == s.length() - 1) {
                return true;
            }
        }
        return false;
    }
}
