package com.problems.easy;

/**
 * Description: 剑指 Offer 42 连续子数组的最大和
 * Link:
 * Author:   lianhai.deng
 * Date:     2023/1/11 10:58
 */
public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int maxResult = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum = Math.max(nums[i], sum + nums[i]);
                maxResult = Math.max(maxResult, sum);
            }
            return maxResult;
        }
    }
}
