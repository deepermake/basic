package com.problems.easy;

/**
 * Description: 1646 获取生成数组中的最大值
 * Link:
 * Author:   lianhai.deng
 * Date:     2023/1/11 11:22
 */
public class GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        Solution solution = new GetMaximumInGeneratedArray().new Solution();
        System.out.println(solution.getMaximumGenerated(7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaximumGenerated(int n) {
            if (n <= 2) {
                return 1;
            }
            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 1;
            int result = 1;
            for (int i = 3; i < n + 1; i++) {
//                if (i % 2 == 0){
//                    temp = i / 2;
//                    nums[i] = nums[temp];
//                    result = Math.max(result, nums[i]);
//                    continue;
//                }
//                 temp = i / 2;
//                nums[i] = nums[temp] + nums[temp+1];
//                result = Math.max(nums[i], result);
                nums[i] = nums[i/2] + (i % 2) * (nums[i/2 + 1]);
                result = Math.max(nums[i], result);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
