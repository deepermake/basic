package com.problems.easy.array.leetcode.editor.cn;

import java.util.*;

/**
 * Description: 15 三数之和
 * Link:        https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 * Author:      lianhai.deng
 * Date:        2022-06-03 13:01:26
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // -4,-1,-1,0,1,2
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 4, 6, 2, 3, 5, -5, 6, -6, 9, 3,3,7};
        solution.threeSum(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
                return res;
            }
            int k = nums.length - 1;
            Set<String> set = new HashSet<>();
            while (k > 1) {
                if (nums[k] < 0) {
                    break;
                }

                int i = 0, j = k - 1;
                while (j > i) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        String str = String.valueOf(nums[i]) + nums[j] + nums[k];
                        if (!set.add(str)) {
                            i++;
                            j--;
                            continue;
                        }
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i++]);
                        list.add(nums[j--]);
                        list.add(nums[k]);
                        res.add(list);
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] < 0) {
                        i++;
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] > 0) {
                        j--;
                    }
                }
                k = k - 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

