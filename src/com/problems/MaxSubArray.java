package com.problems;

/**
 * @description 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @Date 2022/2/23 17:35
 * @Created by lianhai.deng
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, -1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int i = 0, j;
        int max = 0;
        for (; i < len; i++) {
            int current = 0;
            if (i == 0) {
                max = nums[0];
            }
            for (j = i; j < len; j++) {
                current = current + nums[j];
                if (max < current) {
                    max = current;
                }
            }
        }
        return max;
    }
}
