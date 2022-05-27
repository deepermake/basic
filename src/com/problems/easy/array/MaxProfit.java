package com.problems.easy.array;

/**
 * Description: 121. 买卖股票的最佳时机
 * Link:        https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * Author:      lianhai.deng
 * Date:        2022/5/26 15:07
 */
public class MaxProfit {

    public static void main(String[] args) {
        // System.out.println(maxProfit(new int[]{7, 1, 4, 3, 1, 9}));
        System.out.println(maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int begin = 0, end = 1, maxProfit = prices[end] - prices[begin];
        int k = 1;
        while (k < prices.length) {
            if (prices[k] < prices[begin] && prices[k] < prices[end]) {
                end = k;
                begin = k;
            } else if (prices[k] > prices[begin]) {
                end = k;
            } else if (prices[k] < prices[begin]) {
                begin = end;
                end = k;
            }
            maxProfit = Math.max(maxProfit, prices[end] - prices[begin]);
            k++;
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int x : prices) {
            max = Math.max(max, x - min);
            min = Math.min(min, x);
        }
        return max;
    }
}
