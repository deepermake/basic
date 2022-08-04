package com.problems.easy.array.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 39 组合总和
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-07-26 12:11:49
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] candidates = new int[]{2};
        solution.combinationSum(candidates, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            res = backTrack(candidates, 0, target, res, new ArrayList<>(), set);
            return res;
        }

        private List<List<Integer>> backTrack(int[] candidates, int sum, int target, List<List<Integer>> res, List<Integer> current, HashSet<String> set) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>(current);
                String key = list.stream().sorted().map(String::valueOf).collect(Collectors.joining("_"));
                if (!set.contains(key)){
                    res.add(list);
                    set.add(key);
                }
                return null;
            }
            if (sum > target) {
                return res;
            }

            for (int i = 0; i < candidates.length; i++) {
                sum = sum + candidates[i];
                current.add(candidates[i]);
                backTrack(candidates, sum, target, res, current, set);
                sum = sum - candidates[i];
                current.remove(current.size() - 1);
            }

            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

