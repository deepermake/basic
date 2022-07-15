package com.problems.easy.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Description: 453 最小操作次数使数组元素相等
 * todo 还没有提交到leetcode平台
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-25 10:34:55
 */
public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
        int[] arr = new int[]{1, 1, 1};
        solution.minMoves(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            if (nums.length == 1) {
                return nums.length;
            }
            Arrays.sort(nums);
            int max = 0;
            for (int i = 1; i<nums.length;i++){
                max = max + (nums[i]-nums[0]);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

