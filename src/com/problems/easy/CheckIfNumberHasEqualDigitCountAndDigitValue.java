package com.problems.easy;

import java.util.Objects;

/**
 * Description: 2283 判断一个数的数字计数是否等于数位的值
 * Link:
 * Author:   lianhai.deng
 * Date:     2023/1/11 10:18
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberHasEqualDigitCountAndDigitValue().new Solution();
        System.out.println('1' - '0');
        System.out.println(solution.digitCountByHash("1210"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean digitCount(String num) {
            String[] nums = num.split("");
            int n = num.length();
            for (int i = 0; i < n; i++) {
                int times = Integer.valueOf(nums[i]);
                String c = String.valueOf(i);
                int k = 0;
                for (int j = 0; j < n; j++) {
                    if (Objects.equals(c, nums[j])) {
                        k++;
                    }
                }
                if (k != times){
                    return false;
                }
            }
            return true;
        }

        /**
         * 哈希计数
         *
         * @param num
         * @return
         */
        public boolean digitCountByHash(String num) {
            int[] mp = new int[10];
            for (char c : num.toCharArray()) {
                mp[c - '0']++;
            }

            for (int i = 0; i < num.length(); i++) {
                if (mp[i] != num.charAt(i) - '0'){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
