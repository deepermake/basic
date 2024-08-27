package com.problems.easy;

/**
 * 191-位1的个数
 */
public class HammingWeight {


    public static void main(String[] args) {
        System.out.println(String.valueOf(hammingWeight2(2147483645)));
        System.out.println(String.valueOf(hammingWeight2(128)));
        System.out.println(String.valueOf(hammingWeight(11)));
        System.out.println(String.valueOf(hammingWeight(2)));
        System.out.println(String.valueOf(hammingWeight(8)));
    }

    public static int hammingWeight(int n) {
        int result = 0;
        int m;
        while (n >= 2) {
            m = n % 2;
            n = n / 2;
            if (m != 0) {
                result++;
            }
        }
        return result + 1;
    }

    /**
     * 使用位移算法
     *  n & 1代表n与00001进行位运算，结果取决n的最右边的值
     *  n >>>= 1代表将n右移一位的结果
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
