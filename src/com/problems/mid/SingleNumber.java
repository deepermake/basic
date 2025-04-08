package com.problems.mid;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }

    public static int singleNumber(int[] nums) {
        int t = nums[0], n = 3, k = 1;
        while (k < nums.length) {
            if (nums[k] == t) {
                n--;
            }
        }

        return t;
    }
}
