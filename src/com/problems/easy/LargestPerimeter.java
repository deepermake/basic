package com.problems.easy;

import java.util.Arrays;

/**
 * 976 三角形的最大周长
 */
public class LargestPerimeter {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2, 1, 2}));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length - 1;
        while (l >= 2) {
            if (nums[l] >= nums[l - 1] + nums[l - 2]) {
                l--;
                continue;
            }
            return nums[l] + nums[l - 1] + nums[l - 2];
        }
        return 0;
    }
}
