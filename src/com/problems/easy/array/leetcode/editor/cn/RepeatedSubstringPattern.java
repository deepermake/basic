package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 459 重复的子字符串
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-03 15:31:35
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        String s = "abcabcabcabc";
        solution.repeatedSubstringPattern2(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s.length() == 1) {
                return false;
            }
            int len = s.length();
            int i = 0;
            int k = 0;
            boolean result = false;
            while (i < len && k < len / 2 && i + k + 1 < len) {
                if (s.charAt(i) == s.charAt(i + k + 1)) {
                    result = true;
                    i++;
                } else {
                    result = false;
                    i = 0;
                    k++;
                }
            }
            if (!result) {
                return false;
            }
            result = len % (k + 1) == 0;
            return result;
        }

        public boolean repeatedSubstringPattern2(String s) {
            for (int i = 1; i < s.length() / 2; i++) {
                if (s.length() % i == 0) {
                    boolean res = true;
                    for (int j = i; j < s.length(); j++) {
                        if (s.charAt(j) != s.charAt(j - i)) {
                            res = false;
                            break;
                        }
                    }
                    if (res){
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

