package com.problems;

import java.util.Arrays;

public class MaximumProduct {

    public static void main(String[] args) {
        System.out.printf(String.valueOf(maximumProduct(new int[]{2, 6, 5, 4})));
    }

    public static int maximumProduct(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int len = nums.length;
        return nums[len - 1] * nums[len - 2] * nums[len - 3];
    }
}
