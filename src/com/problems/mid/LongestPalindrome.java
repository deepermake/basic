package com.problems.mid;

/**
 * 5 - 最长回文子串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindromeDp("babaddaba"));
        System.out.println(longestPalindromeDp("a"));
        System.out.println(longestPalindromeDp("aa"));
        System.out.println(longestPalindromeDp("abaabaabaa"));
        System.out.println(longestPalindromeDp("abc"));
        System.out.println(longestPalindromeDp("aba"));
        System.out.println(longestPalindromeDp("baa"));
    }

    /**
     * 暴力破解
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (isPalindrome(s, i, j) && result.length() < j - i + 1) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            return false;
        }
        return true;
    }

    /**
     * 动态规划解法
     *
     * @param s
     * @return
     */
    public static String longestPalindromeDp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = i == j;
            }
        }


        int maxLength = 1;
        int begin = 0;
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                if (s.charAt(i) == s.charAt(i + l - 1) && (l == 2 || dp[i + 1][i + l - 2])) {
                    dp[i][i + l - 1] = true;
                    if (maxLength < l){
                        maxLength = l;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLength);


    }
}
