package com.problems.mid;

/**
 * 62 - 不同路径
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));

    }

    /**
     * 解题思路
     * dp[i][j]表示到达坐标{i，j}的路径有多少个
     *
     * 道道{i, j}位置的路径数等于 到达{i-1, j}位置和道道{i, j-1}位置的路径数的和
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
