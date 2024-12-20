package com.problems.mid;

/**
 * 198-打家劫舍
 */
public class Rob {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 4, 2}));
    }

    /**
     * 解题思路
     * dp[i][j] 第i家时，获取的最大金额
     * dp[i] = Math.max(dp[i-2]+nums[i], dp[i-3]+nums[i]}, ;
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        if (l == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (l == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for (int i = 3; i < l; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
        }
        return Math.max(dp[l - 1], dp[l - 2]);

    }
}
