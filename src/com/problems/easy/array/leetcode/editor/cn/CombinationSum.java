package com.problems.easy.array.leetcode.editor.cn;

import java.util.*;

/**
 * Description: 39 组合总和
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-07-26 12:11:49
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        solution.combinationSum(candidates, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            res = backTrack(candidates, candidates[0], 0, target, res, new ArrayList<>());
            return res;
        }

        /**
         *
         * @param candidates 选择数组
         * @param current    当前值
         * @param sum        总和
         * @param target     目标值
         * @param res        符合的结果
         * @param currentList  当前元素集合
         * @return
         */
        private List<List<Integer>> backTrack(int[] candidates, int current, int sum, int target, List<List<Integer>> res, List<Integer> currentList) {
            if (sum == target) {
                // 如果元素的总和等于目标值,则加入结果集
                List<Integer> list = new ArrayList<>(currentList);
                res.add(list);
                return null;
            }
            if (sum > target) {
                // 如果总和大于目标值 直接返回
                return res;
            }

            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] < current) {
                    // 跳过已经计算过的选举元素
                    continue;
                }
                sum = sum + candidates[i];
                currentList.add(candidates[i]);
                // 回溯
                backTrack(candidates, candidates[i], sum, target, res, currentList);
                sum = sum - candidates[i];
                currentList.remove(currentList.size() - 1);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

