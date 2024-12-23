package com.problems.easy;

/**
 * 338 比特位计数
 */
public class CountBits {

    public static void main(String[] args) {
        countBits(50);
    }

    /**
     * 解题思路
     * dp[i] 表示n的1的个数
     * 1、i % 2 == 0 末尾为0，0可以去掉，表示向右移动一位 i/2 所以 dp[i] = dp[i/2]
     * 2、i % 2 == 1 末尾为1, 把这个1减掉，末尾为0，同理，dp[i]-1=dp[(i-1)/2]
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i % 2 == 0 ? dp[i / 2] : dp[(i - 1) / 2] + 1;
        }
        return dp;

    }
}
