package com.problems.easy.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Description: 56 合并区间
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-17 13:48:34
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = new int[][]{{0, 4},{0,6},{0,2}};
        System.out.println(solution.merge(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int[][] m = new int[intervals.length][2];
            for (int i = 0; i < intervals.length; i++) {
                for (int j = i + 1; j < intervals.length; j++) {
                    if (intervals[i][0] > intervals[j][0]) {
                        int[] k = intervals[i];
                        intervals[i] = intervals[j];
                        intervals[j] = k;
                    }
                }
            }
            int l = 1;
            int k = 0;
            int[] temp = intervals[0];
            while (l < intervals.length) {
                if (temp[1] < intervals[l][0]){
                    m[k++] = temp;
                    temp = intervals[l++];
                    continue;
                }
                if (temp[0] >= intervals[l][0]){
                    temp[0] = intervals[l][0];
                }

               if (temp[1] <= intervals[l][1]){
                   temp[1] = intervals[l][1];
               }
               l++;
            }
            m[k++] = temp;
            return Arrays.copyOf(m, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

