package com.problems.easy.array.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Description: 12 整数转罗马数字
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-08-07 21:31:06
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(1994));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            int[] key = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] value = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < key.length; i++) {
                if (num == 0) {
                    return result.toString();
                }
                if (num / key[i] < 1) {
                    continue;
                }
                int addTimes = num / key[i];
                for (int j = 0; j < addTimes; j++) {
                    result.append(value[i]);
                    num = num - key[i];
                }
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

