package com.problems.easy;

public class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        if (nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sum[right];
        }
        return sum[right] - sum[left - 1];
    }
}
