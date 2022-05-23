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
        System.out.println(containsNearbyDuplicateBySet(new int[]{1,2,3,1,2,3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int m = j - i;
                if (nums[i] == nums[j] && m >= -k && m <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateBySet(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = left + k;
        while (left < nums.length) {
            if (!set.add(nums[left])) {
                return true;
            }
            if (left == right) {
                set.remove(nums[right - left]);
                right = left + k;
            }
            left++;
        }

        return false;
    }
}
