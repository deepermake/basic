package com.problems;

import java.util.Arrays;

/**
 * @description 三个数的最大乘积
 *              https://leetcode.cn/problems/maximum-product-of-three-numbers/
 * @Date 2022/5/19 19:51
 * @Created by lianhai.deng
 */
public class MaximumProduct {

    public static void main(String[] args) {
        System.out.println(String.valueOf(maximumProduct(new int[]{-100, 1, 1,2,3, 4, 98})));
    }

    public static int maximumProduct(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
}
