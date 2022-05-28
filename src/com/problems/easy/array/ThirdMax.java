package com.problems.easy.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Description: 414. 第三大的数
 * Link:        https://leetcode.cn/problems/third-maximum-number/
 * Author:      lianhai.deng
 * Date:        2022/5/28 14:49
 */
public class ThirdMax {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 9, 2, 1};
        // System.out.println(thirdMax(nums));
        System.out.println(thirdMaxTreeSet(nums));
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        int max = nums[nums.length - 1];
        int i = nums.length - 1;
        int k = 0;

        while (i > 0 && k < 2) {
            if (nums[i] != nums[i - 1]) {
                k++;
                max = nums[i - 1];
            }
            i--;
        }

        if (k != 2) {
            return nums[nums.length - 1];
        }
        return max;
    }

    /**
     * TreeSet 有序集合的用法
     *
     * @param nums
     * @return
     */
    public static int thirdMaxTreeSet(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int x : nums) {
            treeSet.add(x);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }
}
