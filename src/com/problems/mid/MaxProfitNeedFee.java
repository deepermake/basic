package com.problems.mid;

/**
 * 714 - 买卖股票的最佳时机含手续费
 */
public class MaxProfitNeedFee {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        // dp[i][0] 表示在第i天交易后，没有股票的最大利润
        // dp[i][1] 表示在第i天交易后，持有股票的最大利润
        // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
        // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
        int l = prices.length;
        int[][] dp = new int[l][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < l; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[l - 1][0];
    }
}
