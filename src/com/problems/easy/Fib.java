package com.problems.easy;

/**
 * LCR 126 斐波那契数
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(String.valueOf(fib(0)));
        System.out.println(String.valueOf(fib(1)));
        System.out.println(String.valueOf(fib(2)));
        System.out.println(String.valueOf(fib(3)));
        System.out.println(String.valueOf(fib(4)));
        System.out.println(String.valueOf(fib(5)));
        System.out.println(String.valueOf(fib(6)));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int t = dp[i - 1] + dp[i - 2];
            if (t - 1000000007 > 0) {
                t = t % 1000000007;
            }
            dp[i] = t;
        }
        return dp[n];
    }
}
