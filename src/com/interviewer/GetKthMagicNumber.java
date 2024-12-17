package com.interviewer;

public class GetKthMagicNumber {

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(7));
    }

    /**
     * 解题思路
     * 素因子{3, 5, 7}组成
     * 1 3^0 * 5^0 * 7^0 = 1
     *
     * 2 3^1 * 5^0 * 7^0 = 3
     * 3 3^0 * 5^1 * 7^0 = 5
     * 4 3^0 * 5^0 * 7^1 = 7
     *
     * 5 3^2 * 5^0 * 7^0 = 9
     * 6 3^1 * 5^1 * 7^0 = 15 3 * 5
     * 7 3^1 * 5^0 * 7^1 = 21 3 * 7
     * 8 3^0 * 5^2 * 7^0 = 25 5 * 5

     * 9  3^3 * 5^0 * 7^0 = 27 9 * 3
     * 10 3^0 * 5^1 * 7^1 = 35 5 * 7
     * 11                  = 45 9 * 5
     * 12                    49 7
     *
     *
     * @param k
     * @return
     */
    public static int getKthMagicNumber(int k) {
        return 315;
    }
}
