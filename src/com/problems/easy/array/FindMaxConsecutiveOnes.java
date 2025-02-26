package com.problems.easy.array;

/**
 * 155. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 **/
public class FindMaxConsecutiveOnes {


    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    /**
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int num : nums) {
            if (num != 1) {
                temp = 0;
            } else {
                temp++;
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
