package com.problems.easy;

/**
 * Description: 面试题 16.17 连续数列
 * Link:
 * Author:   lianhai.deng
 * Date:     2023/1/11 15:20
 */
public class ContiguousSequenceLcci {
    public static void main(String[] args) {
        Solution solution = new ContiguousSequenceLcci().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // -2   -2
        // 1    1
        // -3   math.max(-3, -2)   -2
        // 4    math.max(4, -2, 2)  4
        // -1   math.max(-1, 3)     3
        // 2    math.max(2, 3, 5)   5
        // 1    math.max(1, 5, 6)   6

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum = Math.max(sum + nums[i], nums[i]);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
