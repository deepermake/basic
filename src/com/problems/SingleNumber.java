package com.problems;

/**
 * @description 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * @Date 2022/5/19 23:19
 * @Created by lianhai.deng
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3, 1, 1, 2, 2, 4, 4, 5, 5}));
    }

    /**
     * a^a = 0
     * a^0 = a
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int l = nums[0];
        for (int i = 1; i < nums.length; i++) {
            l = l ^ nums[i];
        }
        return l;
    }
}
