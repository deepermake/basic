package com.problems.array;

import java.util.Arrays;

/**
 * Description: 多数元素
 * Link:    https://leetcode.cn/problems/majority-element/
 * Author:   lianhai.deng
 * Date:     2022/5/26 11:11
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int i = 0, k = 1;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                k++;
                if (k > nums.length / 2) {
                    return nums[i];
                }
            } else {
                k = 1;
            }
            i++;
        }
        return 0;
    }
}
