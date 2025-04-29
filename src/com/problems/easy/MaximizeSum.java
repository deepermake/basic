package com.problems.easy;

import java.util.Arrays;

/**
 * 2656 - K个元素的最大和
 */
public class MaximizeSum {

    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[]{1, 2, 3, 4, 5}, 3));
    }

    public static int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int l = nums.length - 1;
        int res = 0;
        while (k > 0) {
            res += nums[l];
            nums[l] = nums[l] + 1;
            k--;
        }
        return res;
    }
}
