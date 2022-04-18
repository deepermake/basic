package com.problems;

/**
 * @author lianhai.deng
 * @description 求平方根 https://leetcode-cn.com/problems/sqrtx/
 * @createTime 2022/4/18 17:40
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }

    public static int mySqrt(int x) {
        int sqrtMax = x;
        int sqrtMin = 0;
        int sqrtNum = x;

        while (sqrtNum * sqrtNum >= x) {
            sqrtNum = sqrtNum / 2;
            if (sqrtNum * sqrtNum < x) {
                sqrtMin = sqrtNum;
            } else if (sqrtNum * sqrtNum == x) {
                return sqrtNum;
            } else if (sqrtNum * sqrtNum > x) {
                sqrtMax = sqrtNum;
            }
        }

        for (int i = sqrtMin; i <= sqrtMax; i++) {
            if (i * i == x) {
                return i;
            }
            if (i * i < x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return sqrtNum;
    }
}
