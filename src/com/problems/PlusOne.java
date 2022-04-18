package com.problems;

import java.util.Arrays;

/**
 * @author lianhai.deng
 * @description 加一 https://leetcode-cn.com/problems/plus-one/
 * @date 2022/4/6 17:54
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        if (len == 0) {
            int k = digits[len] + 1;
            if (k == 10) {
                return new int[]{1, 0};
            } else {
                return new int[]{k};
            }
        }

        int k = 0;
        while (len >= 0) {
            k = digits[len] + 1;
            if (k == 10) {
                digits[len] = 0;
                len = len - 1;
                continue;
            }
            digits[len] = k;
            return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        newDigits[1] = 0;
        if (k == 10) {
            for (int i = 2; i < digits.length - 1; i++) {
                newDigits[i] = digits[i];
            }
        }
        return newDigits;
    }
}
