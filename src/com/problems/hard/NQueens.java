package com.problems.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 51 N 皇后
 * Link:
 * Author:      lianhai.deng
 * Date:        2023-01-09 10:16:09
 */
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 每一行皇后的位置
            int queenIndex[] = new int[n];
            nQueen(n, 0, queenIndex);
            return result;

        }

        /**
         * 回溯法
         *
         * @param n
         */
        public void nQueen(int n, int currentRow, int queenIndex[]) {
            if (currentRow == n) {
                initResult(queenIndex);
                // 如果到达尽头就直接返回
                return;
            }
            // currentCol列下0开始遍历，找到这一列皇后的位置
            for (int j = 0; j < n; j++) {
                // 先尝试放皇后
                queenIndex[currentRow] = j;
                // 判断该皇后的位置是否合理
                if (isValidQueenIndex(n, currentRow, j, queenIndex)) {
                    // 合理 下一行
                    nQueen(n, currentRow + 1, queenIndex);
                }
            }
        }

        public boolean isValidQueenIndex(int n, int currentRow, int currentCol, int queenIndex[]) {
            // 1、当前皇后的位置为{currentRow, currentCol},判断该位置米字各个方向上不存在皇后
            // 2、如果遍历全部后存在皇后返回false，否则返回true
            for (int i = 0; i < currentRow; i++) {
                if (queenIndex[i] == currentCol) {
                    return false;
                }
                // 数学技巧，由于左上斜线和右上斜线的点和当前皇后的点的斜率为1
                if (Math.abs(queenIndex[i] - currentCol) == Math.abs(i - currentRow)) {
                    return false;
                }
            }
            return true;
        }

        public void initResult(int queenIndex[]) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < queenIndex.length; i++) {
                String str = "";
                for (int j = 0; j < queenIndex.length; j++) {
                    if (queenIndex[i] == j){
                        str = str.concat("Q");
                        continue;
                    }
                    str = str.concat(".");
                }
                res.add(str);
            }
            result.add(res);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

