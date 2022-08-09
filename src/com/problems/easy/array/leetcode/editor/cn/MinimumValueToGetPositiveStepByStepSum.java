package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 1413 逐步求和得到正数的最小值
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-08-09 21:37:54
 */
public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        Solution solution = new MinimumValueToGetPositiveStepByStepSum().new Solution();
        int result = solution.minStartValue(new int[]{1,-2,-3});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStartValue(int[] nums) {
            int res = 0;
            int min = 0;
            for (int i = 0; i<nums.length; i++){
                min = Math.min(min, res + nums[i]);
                res = res + nums[i];
            }
            if (min > 0) {
                return min;
            }
            return 1-min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

