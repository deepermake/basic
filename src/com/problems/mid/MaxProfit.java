package com.problems.mid;

/**
 * 122 - 买卖股票的最佳时机II
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 6, 10, 10, 100}));
    }

    public static int maxProfit(int[] prices) {
        int earn = 0;
        int l = prices.length;
        int i = 0, j = 1;
        while (j < l) {
            if (prices[i] < prices[j]) {
                earn += prices[j] - prices[i];
                i++;
                j++;
                continue;
            }

            i = j;
            j++;

        }
        return earn;
    }
}
