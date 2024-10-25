package com.interviewer;

/**
 * 面试题 17.16 按摩师
 */
public class Massage {

    public static void main(String[] args) {
        System.out.println(massage(new int[]{1, 2, 3, 1}));
        System.out.println(massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    /**
     * 思路
     * 定义一个常量result，来表示dp[i-2]前最大预约时间
     * dp[i]表示接到i个客人时的总时间 dp[i] = nums[i-1] + Math.max(dp[i-2], result)
     * result = Math.max(result, dp[i-2])
     *
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int result = 0;
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = nums[i - 1] + Math.max(dp[i - 2], result);
            result = Math.max(result, dp[i - 2]);
        }
        return Math.max(dp[nums.length], dp[nums.length - 1]);
    }
}
