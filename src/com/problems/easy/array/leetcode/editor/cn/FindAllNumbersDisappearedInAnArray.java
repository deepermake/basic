package com.problems.easy.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 448 找到所有数组中消失的数字
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-05-30 20:19:19
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        int[] nums = new int[]{1,1};
        solution.findDisappearedNumbers(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= nums.length; i++) {
                list.add(i);
            }
            for (Integer x : nums) {
                if (list.contains(x)) {
                    list.remove(x);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

