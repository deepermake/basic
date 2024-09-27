package com.problems.mid;

/**
 * LCR 020 回文字串
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = s.length();
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                if (s.charAt(i) != s.charAt(i + l - 1)) {
                    continue;
                }

                if (i + 1 == i + l - 2) {
                    result++;
                    dp[i][i + l - 1] = true;
                    continue;
                }

                if (l == 2 || dp[i+1][i+l-2]){
                    result++;
                    dp[i][i+l-1] = true;
                }
            }
        }
        return result;
    }
}
