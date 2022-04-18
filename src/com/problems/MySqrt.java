package com.problems;

/**
 * @author lianhai.deng
 * @description 求平方根 https://leetcode-cn.com/problems/sqrtx/
 * @createTime 2022/4/18 17:40
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1){
            return 1;
        }
        int sqrtMax = x;
        int sqrtMin = 0;
        int sqrtNum = x;

        while (sqrtNum >= x / sqrtNum) {
            sqrtNum = sqrtNum / 2;
            if (sqrtNum < x / sqrtNum) {
                sqrtMin = sqrtNum;
            } else if (sqrtNum * sqrtNum == x) {
                return sqrtNum;
            } else if (sqrtNum > x / sqrtNum) {
                sqrtMax = sqrtNum;
            }
        }

        for (int i = sqrtMin; i <= sqrtMax; i++) {
            if (i * i == x) {
                return i;
            }
            if (i <= x / i && (i + 1) > x / (i + 1)) {
                return i;
            }
        }
        return sqrtNum;
    }
}
