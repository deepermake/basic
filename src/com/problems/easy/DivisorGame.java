package com.problems.easy;

/**
 * 1025 - 除数博弈
 */
public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(divisorGame(100));
    }

    /**
     * 动态规划
     * dp[i]表示n时，是否会赢
     * dp[0] = false
     * dp[1] = false
     * dp[2] = true
     *
     * @param n
     * @return
     */
    public static boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j != 0) {
                    continue;
                }
                if (!dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
