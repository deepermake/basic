package com.problems.mid;

/**
 * Description: 5 最长回文子串
 * Link:
 * Author:   lianhai.deng
 * Date:     2023/1/14 10:08
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // 123kkfffdfdk
        // cbbd
        // babad
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            Boolean[][] dp = new Boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    dp[i][j] = i == j;
                }
            }
            int maxLength = 1;
            int begin = 0;
            for (int l = 2; l <= s.length(); l++) {
                for (int i = l - 1; i <= s.length() - 1; i++) {
                    // 如果头尾两个字符不一致，则这个字符串不是回文字符串
                    if (s.charAt(i) != s.charAt(i - l + 1)) {
                        continue;
                    }
                    // 1、如果字符串的长度为2且头尾两个字符一致，则是回文字符串
                    // 2、如果头尾字符一致，且[i-l+2...i-1]是回文字符串，则是回文字符串
                    if (l == 2 || dp[i - l + 2][i - 1]) {
                        dp[i - l + 1][i] = true;
                        if (l > maxLength) {
                            maxLength = l;
                            begin = i - l + 1;
                        }
                    }
                }
            }
            return s.substring(begin, begin + maxLength);
        }
    }
}
