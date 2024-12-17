package com.interviewer;

/**
 * 面试题 08.01 三步问题
 */
public class WaysToStep {

    public static void main(String[] args) {
        System.out.println(waysToStep(99));
    }

    /**
     * 解题思路
     * dp[i]表示跳到第i个台阶的方式数
     * dp[i-1]
     * <p>
     * 0  0
     * 1  1
     * 2  2
     * 3  4
     * 4  7
     * 5  13
     *
     * @param n
     * @return
     */
    public static int waysToStep(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        // 3个数相加，可能出现3数之和超过最大值，负数
        for (int i = 4; i <= n; i++) {
            int t = dp[i - 2] + dp[i - 3];
            if (t - 1000000007 > 0){
                t = t % 1000000007;
            }
            if (dp[i - 1] + t - 1000000007 > 0){
                dp[i] = (dp[i - 1] + t) % 1000000007;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] = dp[i] % 1000000007;
        }
        // 92295268
        return dp[n];

    }

}
