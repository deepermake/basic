package com.interviewer;

import java.util.Arrays;

/**
 * 面试题 17.04 消失的数字
 */
public class MissingNumber {

    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1, 8}));
        System.out.println(missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1, 8}));
    }

    /**
     * 无脑做法
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums[n - 1] + 1;
    }

    /**
     * 高斯定理做法
     *
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return n * (n + 1) / 2 - sum;
    }
}
