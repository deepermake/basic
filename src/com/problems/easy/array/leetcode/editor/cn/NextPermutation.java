package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 31 下一个排列 todo
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-17 16:38:44
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = new int[]{1, 4, 6, 3, 7, 5, 3, 4};
        solution.nextPermutation(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length == 1) {
                return;
            }
            int k = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    k = i;
                }
            }
            if (k == 0) {
                reverse(nums);
                return;
            }
            swap(nums, k - 1, k);
            reverse(nums);
        }

        public void swap(int[] nums, int indexStar, int indexEnd) {
            int k = nums[indexStar];
            nums[indexStar] = nums[indexEnd];
            nums[indexEnd] = k;
        }

        public void reverse(int[] nums){
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - i - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

