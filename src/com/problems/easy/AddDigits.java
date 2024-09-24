package com.problems.easy;

/**
 * 258-各位相加
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(2245));
    }

    public static int addDigits(int num) {

        int result = 0;
        while (num > 0 || result > 9) {

            if (num == 0) {
                num = result;
                result = 0;
            }
            result = result + (num % 10);
            num = num / 10;
        }
        return result;

    }


    /**
     * 数根的概念
     *
     * @param num
     * @return
     */
    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;

    }
}
