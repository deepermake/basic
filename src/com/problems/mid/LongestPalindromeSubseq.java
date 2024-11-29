package com.problems.mid;

/**
 * 516 - 最长回文子序列
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abbabbb"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    /**
     * 解题思路
     * dp[i][j], 下标i到j最大子序列长度
     * 已知条件
     * dp[0][0]...dp[n-1][n-1] = 1;
     * 用长度l表示，当j=i+l-1,dp[i][j]最长回文子序列长度
     * 1、当s[i] != s[j]时
     * 长度l的最长回文子序列长度由l-1长度的最长回文子序列数决定
     * l-1 = {i+1,j} or {i,j-1}两种情况
     * dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
     * 2、当s[i] = s[j]时，
     * 长度l由dp[i+1][j-1]+2决定
     * dp[i][j] = Match.max(dp[i][j], dp[i+1][j-1}+2)
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
