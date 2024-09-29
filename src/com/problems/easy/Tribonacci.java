package com.problems.easy;

/**
 * 1137 - 第N个泰波那契数
 */
public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(5));
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i- 2] + dp[i - 3];
        }
        return dp[n];
    }
}
