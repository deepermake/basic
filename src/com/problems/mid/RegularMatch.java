package com.problems.mid;

/**
 * 10 正则表达式匹配
 */
public class RegularMatch {

    public static void main(String[] args) {
        // System.out.println(isMatch("aaa", "ab*.*"));
        System.out.println(isMatch("ab", "ab*"));
        // System.out.println(isMatch("abab", ".*b"));
    }

    /**
     * 解题思路
     * dp[i][j] s的前i个字符是否与p的前j个字符匹配
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[s.length()][p.length()];
        char[] srr = s.toCharArray();
        char[] prr = p.toCharArray();
        dp[0][0] = true;

        for (int j = 1; j < prr.length; j++) {
            if (j > 1 && prr[j] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < srr.length; i++) {
            for (int j = 1; j < prr.length; j++) {
                if (prr[j] != '*') {
                    dp[i][j] = match(srr[i], prr[j]) && dp[i - 1][j - 1];
                    continue;
                }
                // *号的情况
                if (match(srr[i], prr[j - 1])) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                } else {
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }

    public static boolean match(char s, char p) {
        if (p == '.') {
            return true;
        }
        return s == p;
    }
}
