package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 80 删除有序数组中的重复项 II
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-09 16:08:28
 */
public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        solution.removeDuplicates(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int a = 2;
            int j = 2;
            while (j < nums.length) {
                if (nums[j] != nums[j - 2]) {
                    nums[a] = nums[j];
                    a ++;
                }
                j++;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

