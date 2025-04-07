package com.problems;

import java.util.Arrays;

/**
 * 594 - 最长和谐子序列
 */
public class FindLHS {

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int max = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] > 1) {
                left++;
                continue;
            }
            if (nums[right] - nums[left] < 1) {
                right++;
                continue;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
