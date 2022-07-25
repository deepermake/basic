package com.problems.easy.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 17 电话号码的字母组合
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-07-23 20:41:23
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("234");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.equals("")) {
                return new ArrayList<>();
            }
            char[] num = digits.toCharArray();
            List<String> res;
            res = backTrack(num, "", new ArrayList<>(), digits.length());
            System.out.println(res);
            return res;
        }

        public List<String> backTrack(char[] s, String param, List<String> res, int n) {
            if (param.length() == n) {
                res.add(param);
                return null;
            }
            for (int i = 0; i < s.length; i++) {
                char num = s[i];
                String word = map(num);
                for (int j = 0; j < word.length(); j++) {
                    param = param.concat(String.valueOf(word.charAt(j)));
                    backTrack(Arrays.copyOfRange(s, 1, s.length), param, res, n);
                    param = String.copyValueOf(param.toCharArray(), 0, param.length() - 1);
                }
                s = Arrays.copyOfRange(s, 1, s.length);
            }
            return res;
        }

        /**
         * 映射
         *
         * @param number
         * @return
         */
        private String map(char number) {
            String word = "";
            switch (number) {
                case '2':
                    word = "abc";
                    break;
                case '3':
                    word = "def";
                    break;
                case '4':
                    word = "ghi";
                    break;
                case '5':
                    word = "jkl";
                    break;
                case '6':
                    word = "mno";
                    break;
                case '7':
                    word = "pqrs";
                    break;
                case '8':
                    word = "tuv";
                    break;
                case '9':
                    word = "wxyz";
                    break;
            }
            return word;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

