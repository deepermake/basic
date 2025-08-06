package com.problems.mid;

import java.util.Objects;

/**
 * 647 回文字串
 */
public class CountSubstrings2 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = s.length();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; i + j < s.length(); j++) {
                if (!Objects.equals(s.charAt(j), s.charAt(i + j))) {
                    continue;
                }
                if (i == 1) {
                    dp[j][i + j] = true;
                    result++;
                    continue;
                }

                if (dp[j + 1][i + j - 1]) {
                    dp[j][i + j] = true;
                    result++;
                }

            }
        }
        return result;
    }
}
