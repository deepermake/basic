package com.problems.easy.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Description: 125 验证回文串
 * Link:        https://leetcode.cn/problems/valid-palindrome/
 * Author:      lianhai.deng
 * Date:        2022-06-04 21:15:14
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        String s = "Aad";
        System.out.println(solution.isPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            char[] chars = new char[s.length()];
            int k = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
                    chars[k++] = c;
                }
            }
            if (chars[0] == ' ') {
                return true;
            }
            char[] res = Arrays.copyOf(chars, k);
            int i = 0, j = res.length - 1;
            while (i < j) {
                if (res[i++] != res[j--]) {
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

