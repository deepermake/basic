package com.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 326 - 3的幂
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree3(27));
    }

    public static boolean isPowerOfThree(int n) {

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 计算所有3的倍数
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = 3;

        while (temp <= Integer.MAX_VALUE / 3) {
            set.add(temp);
            temp = temp * 3;
        }

        return n > 0 && set.contains(n);

    }

    /**
     * 找到3的最大幂值为1162261467，所有3的幂值都能被它整除
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree3(int n) {

        return n > 0 && 1162261467 % n == 0;

    }
}
