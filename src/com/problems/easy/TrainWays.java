package com.problems.easy;

/**
 * LCR 127 跳跃训练
 */
public class TrainWays {

    public static void main(String[] args) {
        System.out.println(trainWays(100));
    }

    /**
     * 动态规划解法
     * dp[i] 表示第i个格子时的路径有多少
     * <p>
     * dp[0] = 0;
     * dp[1] = 1;
     * dp[2] = 2;
     * <p>
     * dp[3] = dp[2] + dp[1];
     *
     * @param n
     * @return
     */
    public static int trainWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[i - 1] + dp[i - 2];
            if (sum - 1000000007 > 0) {
                dp[i] = sum % 1000000007;
                continue;
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
