package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 2259 移除指定数字得到的最大结果
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-16 16:38:02
 */
public class RemoveDigitFromNumberToMaximizeResult {
    public static void main(String[] args) {
        Solution solution = new RemoveDigitFromNumberToMaximizeResult().new Solution();
        String number = "2918247756338836829948259212259612948986573547572133445495998236287245768816987491842618661";
        char digit = '9';
        System.out.println(solution.removeDigit(number, digit));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDigit(String number, char digit) {
            String max = "";
            String maxStr = "";
            for (int i = 0; i < number.length(); i++) {
                if (digit == number.charAt(i)) {
                    // String now = maxStr.concat(number.replaceFirst(maxStr.concat(String.valueOf(number.charAt(i))), ""));
                    String now = number.substring(0, i)+number.substring(i+1);
                    if (now.compareTo(max) > 0) {
                        max = now;
                    }
                }
                maxStr = maxStr.concat(String.valueOf(number.charAt(i)));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

