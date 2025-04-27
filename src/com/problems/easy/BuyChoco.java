package com.problems.easy;

import java.util.Arrays;

/**
 * 2706 - 购买两块巧克力
 */
public class BuyChoco {
    public static void main(String[] args) {
        System.out.println(buyChoco(new int[]{1, 2, 2}, 3));
    }

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] > money || prices[0] + prices[1] > money) {
            return money;
        }
        return money - prices[0] - prices[1];
    }
}
