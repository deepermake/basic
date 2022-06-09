package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 26 删除有序数组中的重复项
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-09 13:34:34
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        solution.removeDuplicates(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int a = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[a] = nums[i];
                    a++;
                }
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

