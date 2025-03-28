package com.problems.mid;

import java.util.Arrays;


/**
 * 31 - 下一个排列
 */
public class NextPermutation {

    public static void main(String[] args) {
        //nextPermutation(new int[]{1, 2, 3});
        // nextPermutation(new int[]{4, 6, 7, 2, 6, 1, 3, 2});
        // nextPermutation(new int[]{1, 3, 2, 2, 2, 2, 2});
        // nextPermutation(new int[]{1, 2, 3});
        // nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1,1,5});
    }

    /**
     * 双指针解法
     * [1,3,2,1] 找到 [1, 3]
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int end = nums.length - 1;
        int start = end - 1;
        boolean flag = false;
        while (start >= 0) {
            if (nums[start] < nums[end]) {
                flag = true;
                break;
            }
            start--;
            end--;
        }

        if (!flag) {
            Arrays.sort(nums);
            return;
        }

        int index = getMin(nums[start], nums, end);
        int temp = nums[index];
        nums[index] = nums[start];
        nums[start] = temp;

        Arrays.sort(nums, end, nums.length);
    }

    /**
     * 从[nums[i] ~ nums.len-1] 中找到一个比num大，且在集合中最小的数
     *
     * @param num
     * @param nums
     * @param i
     * @return
     */
    public static int getMin(int num, int[] nums, int i) {
        for (int l = nums.length - 1; l > i; l--) {
            if (nums[l] > num) {
                return l;
            }
        }
        return i;
    }
}
