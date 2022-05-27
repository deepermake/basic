package com.problems.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 268. 丢失的数字
 * Link:        https://leetcode.cn/problems/missing-number/
 * Author:      lianhai.deng
 * Date:        2022/5/26 22:52
 */
public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int len = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        for (int i = 0; i < len+1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
