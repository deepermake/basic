package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 941. 有效的山脉数组
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-08 22:18:27
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new ValidMountainArray().new Solution();
        int[] arr = new int[]{0, 3, 4, 9, 5, 2, 6};
        solution.validMountainArray(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length <= 2) {
                return false;
            }

            if (arr[0] >= arr[1]) {
                return false;
            }

            int len = arr.length;
            int index = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] == arr[i]){
                    return false;
                }
                if (arr[i - 1] > arr[i]) {
                    index = i;
                    break;
                }
            }

            for (int j = index + 1; j < len; j++) {
                if (arr[j - 1] <= arr[j]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

