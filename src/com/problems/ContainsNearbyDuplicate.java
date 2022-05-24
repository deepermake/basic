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
        System.out.println(containsNearbyDuplicateBySet(new int[]{1,0,1,1}, 1));
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
        int left = 0, right = 0;
        while (right < nums.length) {
            if (!set.add(nums[right++])) {
                return true;
            }
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
