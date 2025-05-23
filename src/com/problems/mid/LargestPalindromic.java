package com.problems.mid;

/**
 * 2384 - 最大回文数字
 */
public class LargestPalindromic {

    public static void main(String[] args) {
        // System.out.println(largestPalindromic("444947137"));
        // System.out.println(largestPalindromic("00009"));
        System.out.println(largestPalindromic("0000"));
        // System.out.println(largestPalindromic("00000"));
    }


    public static String largestPalindromic(String num) {
        String s = "";
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0'] += 1;
        }

        int t = -1;
        for (int i = 0; i < 10; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i] % 2 == 0) {
                continue;
            }
            arr[i] = arr[i] - 1;
            t = Math.max(t, i);
        }
        if (t != -1) {
            s = "" + t;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] < 2) {
                continue;
            }
            int m = arr[i] / 2;
            for (int j = 0; j < m; j++) {
                s = i + s + i;
            }
        }
        int i = 0;
        while (i < s.length() / 2 && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i, s.length() - i == i ? i + 1 : s.length() - i);
    }
}
