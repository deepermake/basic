package com.problems;

/**
 * @description 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @Date 2022/2/23 17:35
 * @Created by lianhai.deng
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0 , max = nums[0];
        for (int x : nums) {
            pre = Math.max(x, pre + x);
            max = Math.max(pre, max);
        }
        return max;
    }
}

