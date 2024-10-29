package com.interviewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.02 迷路的机器人
 */
public class PathWithObstacles {

    public static void main(String[] args) {
        // List<List<Integer>> list = pathWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        // List<List<Integer>> list = pathWithObstacles(new int[][]{{0, 0}});
        List<List<Integer>> list = pathWithObstacles(new int[][]{{0, 1},{1,0}});
        System.out.println(list);
    }

    /**
     * 解题思路
     * 动态规划
     * dp[i][j] 表示是否可以到达{i,j}这个位置
     * dp[i][j] = (dp[i-1][j] || dp[i][j-1]) && obstacleGrid[i][j]
     * dp[0][0] = obstacleGrid[0][0];
     * <p>
     * 回溯
     *
     * @param obstacleGrid
     * @return
     */
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int lenX = obstacleGrid[0].length;
        int lenY = obstacleGrid.length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[lenY - 1][lenX - 1] == 1) {
            return new ArrayList<>();
        }

        boolean[][] dp = new boolean[lenY][lenX];
        dp[0][0] = true;
        for (int i = 1; i < lenX; i++) {
            dp[0][i] = dp[0][i - 1] && obstacleGrid[0][i] == 0;
        }
        for (int i = 1; i < lenY; i++) {
            dp[i][0] = dp[i - 1][0] && obstacleGrid[i][0] == 0;
        }

        for (int i = 1; i < lenY; i++) {
            for (int j = 1; j < lenX; j++) {
                dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]) && obstacleGrid[i][j] == 0;
            }
        }

        if (!dp[lenY - 1][lenX - 1]){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int i = lenY - 1, j = lenX - 1;
        while (i != 0 || j != 0) {
            result.add(0, Arrays.asList(i, j));
            if (i - 1 >= 0 && dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        result.add(0, Arrays.asList(i, j));
        return result;
    }
}
