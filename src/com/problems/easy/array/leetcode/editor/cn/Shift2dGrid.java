package com.problems.easy.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1260 二维网格迁移
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-05-31 15:48:56
 */
public class Shift2dGrid {
    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        solution.shiftGrid(grid, k);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            List<List<Integer>> list = new ArrayList<>();

            int y = grid.length;
            int x = grid[0].length;
            int nums = Math.multiplyExact(x, y);
            if (k > nums) {
                k = k / nums;
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    grid[(i + k) / y][(j + k) / x] = grid[i][j];
                }
            }

            for (int i = 0; i < y; i++) {
                List<Integer> re = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    re.add(grid[i][j]);
                }
                list.add(re);
            }


            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

