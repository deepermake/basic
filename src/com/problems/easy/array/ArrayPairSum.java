package com.problems.easy.array;

import java.util.Arrays;

/**
 * 561 - 数组拆分
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }


    /**
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            result = result + nums[i];
        }
        return result;
    }
}
