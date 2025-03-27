package com.problems.mid;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        //nextPermutation(new int[]{1, 2, 3});
        nextPermutation(new int[]{4, 6, 7, 2, 6, 1, 3, 2});
    }

    /**
     * 双指针解法
     * end指针为 nums.length - 1;
     * <p>
     * 下标，下标对应的值
     * <p>
     * 只要从尾巴开始关注3个数
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        // 慢指针，数组尾巴
        int end = nums.length - 1;
        // 快指针，


        Arrays.sort(nums);
    }
}
