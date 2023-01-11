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
        // 10 [10]       -- 10
        // 15 [15]       -- 15
        // 20 [30, 35]   -- 30
        // 21 [36, 41]   -- 36
        // 3  [33, 39]   -- 33
        // 5  [41,44]    -- 38
        // 99 [140, 143] --
        // 20 [25, 119]  -- 58
        // 0  [20, 99]   -- 58
        // 20 [40, 20]   -- 78
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int dp[] = new int[cost.length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < cost.length; i++) {
                dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
            }
            return Math.min(dp[cost.length-1], dp[cost.length - 2]);
        }

    }
}
