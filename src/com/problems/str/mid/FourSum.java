package com.problems.str.mid;

import java.util.*;

/**
 * 18-四数之和
 */
public class FourSum {

    public static void main(String[] args) {
        // System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -299999999));
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
            // 固定第二个
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 双指针互相移动，得到结果
                int k = j + 1;
                int m = nums.length - 1;
                while (k < m) {
                    int res = nums[i] + nums[j] + nums[k];
                    int temp = target - nums[m];
                    String key = nums[i] + "_" + nums[j] + "_" + nums[k] + "_" + nums[m];
                    if (res == temp && !set.contains(key)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        lists.add(list);
                        set.add(key);
                    }
                    if (res > temp) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }
        return lists;
    }
}
