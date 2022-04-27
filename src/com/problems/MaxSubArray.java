package com.problems;

/**
 * @description 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @Date 2022/2/23 17:35
 * @Created by lianhai.deng
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int x : nums) {
            if (pre + x <= x) {
                pre = x;
            } else {
                pre = pre + x;
            }
            if (pre > max) {
                max = pre;
            }
        }
        return max;
    }
}

