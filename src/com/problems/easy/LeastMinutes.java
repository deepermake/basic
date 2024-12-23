package com.problems.easy;

/**
 * LCS 01 下载插件
 */
public class LeastMinutes {

    public static void main(String[] args) {
        System.out.println(leastMinutes(3));
        System.out.println(leastMinutes(4));
        System.out.println(leastMinutes(5));
        System.out.println(leastMinutes(6));
    }

    /**
     * 解题思路，
     * dp[i]表示i个插件需要的最少时间
     * dp[0] = 0
     * dp[1] = 1
     * dp[2] = 2
     * dp[3] = 2
     * dp[4] = 3
     * dp[5] = 3
     * dp[6] = 4
     * dp[7] = 4
     * 0,1,2
     * dp[i] = Math.min(dp[i-1]+1, dp[i-2]+2)
     *
     * @param n
     * @return
     */
    public static int leastMinutes(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = i;
            dp[i] += dp[i-2];

        }

        return dp[n];
    }
}
