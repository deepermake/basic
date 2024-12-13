package com.problems.mid;

/**
 * 221 - 最大正方形
 */
public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}}));

    }
    /**
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     */

    /**
     * 现有的信息
     * 1、形成正方形必须是连续的1
     * 2、正方形的最大边长不超过matrix.length
     * <p>
     * 解题思路
     * dp[i][j]表示以坐标{i，j}为右下角的最大正方形边长
     * <p>
     * 1、matrix[i-1][j-1] = 0 || matrix[i-1][j] = 0 || matrix[i][j-1] = 0 则 dp[i][j] = matrix[i][j]
     * 2、dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1
     * <p>
     * <p>
     * <p>
     * <p>
     * [
     * ['1","0","1","1","0"],
     * ["1","0","1","1","1"],  4
     * ["1","1","1","1","1"],  4
     * ["1","0","0","1","0"]
     * ]
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == '0' || matrix[i - 1][j - 1] == '0' || matrix[i - 1][j] == '0' || matrix[i][j - 1] == '0') {
                    dp[i][j] = matrix[i][j] - 48;
                    result = Math.max(result, dp[i][j]);
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }

        return result * result;
    }
}
