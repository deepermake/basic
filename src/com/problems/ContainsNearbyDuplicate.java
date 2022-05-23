package com.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lianhai.deng
 * @description 存在重复元素 II
 * https://leetcode.cn/problems/contains-duplicate-ii/
 * @createTime 2022/5/23 20:11
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) {

                }
            }
        }
        Math.abs(-3);
        return false;
    }
}
