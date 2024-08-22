package com.problems.str.mid;

import java.util.*;

/**
 * 18-四数之和
 */
public class FourSum {

    public static void main(String[] args) {
        // System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        // System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -299999999));
        System.out.println(fourSum(new int[]{4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5}, -13));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        // 排序
        Arrays.sort(nums);

        // 固定第一个
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (target > 0 && nums[i] > target) {
                return lists;
            }

            // 固定第二个
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 双指针互相移动，得到结果
                int k = j + 1;
                int m = nums.length - 1;
                while (k < m) {
                    long res = (long) nums[i] + nums[j] + nums[k] + nums[m];
                    if (res > target) {
                        m--;
                        continue;
                    }
                    if (res < target) {
                        k++;
                        continue;
                    }
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                    while (m > k + 1 && nums[m] == nums[m - 1]) {
                        m--;
                    }
                    while (k + 1 < m && nums[k] == nums[k + 1]) {
                        k++;
                    }
                    m--;
                    k++;
                }
            }
        }
        return lists;
    }
}
