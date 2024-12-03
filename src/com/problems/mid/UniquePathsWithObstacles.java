package com.problems.mid;

/**
 * 63 - 不同路径
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}}));
    }

    /**
     * dp[i][j]表示到达dp[i][j]点的路径数
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lenX = obstacleGrid.length;
        int lenY = obstacleGrid[0].length;
        if (obstacleGrid[lenX - 1][lenY - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[lenX][lenY];
        dp[0][0] = 1;
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (j == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[lenX - 1][lenY - 1];
    }
}
