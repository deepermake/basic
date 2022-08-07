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
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1000, "M");
            map.put(900, "CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");
            String result = "";
            for (int i = 0; i < key.length; i++) {
                if (num == 0) {
                    return result;
                }
                if (num / key[i] < 1) {
                    continue;
                }
                int addTimes = num / key[i];
                for (int j = 0; j < addTimes; j++) {
                    result = result + map.get(key[i]);
                    num = num - key[i];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

