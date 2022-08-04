package com.problems.easy.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1403 非递增顺序的最小子序列
 * Link:        https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 * Author:      lianhai.deng
 * Date:        2022-08-04 17:17:20
 */
public class MinimumSubsequenceInNonIncreasingOrder {
    public static void main(String[] args) {
        Solution solution = new MinimumSubsequenceInNonIncreasingOrder().new Solution();
        solution.minSubsequence(new int[]{6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            // 如果只有一个元素直接返回
            if (nums.length == 0) {
                return new ArrayList<>(nums[0]);
            }
            // 先排序
            Arrays.sort(nums);
            // 算出元素总和
            int sum = Arrays.stream(nums).sum();
            List<Integer> res = new ArrayList<>();
            // 前几位相加对和
            int current = 0;
            int k = nums.length - 1;
            while (k>= 0){
                current = current + nums[k];
                if (current > sum - current){
                    // 相加到某个元素大于省下的元素和则返回
                    res.add(nums[k]);
                    break;
                }
                res.add(nums[k]);
                k = k - 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

