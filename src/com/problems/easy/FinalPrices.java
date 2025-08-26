package com.problems.easy;

import java.util.Stack;

/**
 * 1475 - 商品折扣后的最终价格
 */
public class FinalPrices {

    public static void main(String[] args) {
        finalPrices(new int[]{8, 4, 6, 2, 3});
    }

    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                res[stack.peek()] = prices[stack.pop()] - prices[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.peek()] = prices[stack.pop()];
        }
        return res;
    }
}
