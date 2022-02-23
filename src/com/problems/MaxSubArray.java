package com.problems;

/**
 * @description 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @Date 2022/2/23 17:35
 * @Created by lianhai.deng
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return nums[0];
        }
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                pre = Math.max(pre, pre+nums[i]);
            }
            max = Math.max(pre, max);
        }
        return max;
    }
}
