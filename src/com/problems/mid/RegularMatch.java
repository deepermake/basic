package com.problems.mid;

public class RegularMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("abb", ".*"));
        // System.out.println(isMatch("ab", "a"));
        // System.out.println(isMatch("abab", ".*b"));
    }

    /**
     * 解题思路
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 遍历s逐一比对,记录s和p的下标
     * 当p中遇到i时，p不变s+1
     * dp数组表示，s的每个小标是否符合正则要求
     * dp[i] = dp[i-1] &&
     * 有几种情况
     * 1、遍历到p为‘.’时不用考虑是否相等 dp[i] = dp[i-1];
     * 2、遍历到p为‘*’时表示无线复制前一个dp[i] = dp[i-1];
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (p.length() > s.length() || (!p.contains("*") && p.length() != s.length())) {
            return false;
        }
        boolean[] dp = new boolean[s.length()];
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            dp[0] = true;
        } else {
            return false;
        }
        int j = 1;
        for (int i = 1; i < s.length(); i++) {
            if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                dp[i] = dp[i - 1];
                j++;
                continue;
            }

            // *表示可以无限复制前一个
            if (p.charAt(j) == '*') {
                if (s.charAt(i) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i] = dp[i - 1];
                    if (p.length() - j == s.length() - i) {
                        j++;
                    }
                    continue;
                }
            }
            return false;
        }

        return dp[s.length() - 1];
    }
}
