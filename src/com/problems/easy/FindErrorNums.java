package com.problems.easy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 645 - 错误的集合
 */
public class FindErrorNums {
    public static void main(String[] args) {
        findErrorNums(new int[]{1, 2, 3, 2, 5});
        findErrorNums(new int[]{1, 2, 2, 4});
        findErrorNums(new int[]{3, 2, 2});
    }

    /**
     * nums数组对应的值，以及下标
     * 如果值已经在集合中存在了，就放入结果，
     * 如果下标在集合中存在了，跳过，如果不存在就放入结果
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {

        int[] arr = new int[2];
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] == i && !set.contains(i)) {
                set.add(nums[i - 1]);
                continue;
            }

            if (set.contains(nums[i-1])){
                arr[0] = nums[i-1];
            }

            if (!set.contains(i)) {
                arr[1] = i;
            }

            set.add(nums[i - 1]);
        }

        return arr;
    }
}
