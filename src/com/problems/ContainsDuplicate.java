package com.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lianhai.deng
 * @description 存在重复数据  https://leetcode.cn/problems/contains-duplicate/
 * @createTime 2022/5/23 19:57
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 4}));
        System.out.println(containsDuplicateHash(new int[]{1, 2, 3, 4, 4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
