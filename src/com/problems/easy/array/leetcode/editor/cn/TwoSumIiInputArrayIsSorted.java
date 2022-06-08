package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 167 两数之和 II - 输入有序数组
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-08 23:24:51
 */
public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] nums = new int[]{1,0};
        solution.twoSum(nums, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] res = new int[2];
            int i = 1, j = numbers.length;
            while (i < j) {
                if (target == numbers[i - 1] + numbers[j - 1]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
                if (target < numbers[i - 1] + numbers[j - 1]) {
                    j--;
                    continue;
                }
                if (target > numbers[i - 1] + numbers[j - 1]) {
                    i++;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

