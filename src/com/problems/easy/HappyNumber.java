package com.problems.easy;

/**
 * 202 快乐数
 */
public class HappyNumber {
    public static void main(String[] args) {
        // System.out.println(isHappy(19));
        // System.out.println(isHappy(20));
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        while (n == 7 || n >= 10) {
            int sum = 0;
            String s = String.valueOf(n);
            for (int i = 0; i < s.length(); i++) {
                int k = Integer.parseInt(String.valueOf(s.charAt(i)));
                sum = sum + (k * k);
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
