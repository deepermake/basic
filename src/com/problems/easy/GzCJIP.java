package com.problems.easy;

/**
 * Description: 剑指 Offer II 088爬楼梯的最少成本
 * Link:
 * Author:   lianhai.deng
 * Date:     2023/1/11 11:57
 */
public class GzCJIP {
    public static void main(String[] args) {
        Solution solution = new GzCJIP().new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20, 21, 3, 5, 99, 20, 0, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));

    }

    /**
     * 解题思路
     * cost[i]表示第i阶台阶向上的花费 cost[0] 表示第一个台阶的
     * dp[i]表示到达第i-1节的花费 dp[i] = {dp[i-1] + cost[i-1]} or {dp[i-2] + cost[i-2]}
     * <p>
     * dp[i]的最小花费 = Math.min{dp[i-1]+cost[i-1], dp[i-2] + cost[i-2]}
     */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            // 一共有len个台阶
            int dp[] = new int[cost.length + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i < cost.length + 1; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[cost.length];
        }

    }
}
