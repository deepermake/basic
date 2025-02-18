package com.problems.easy;

/**
 * LCP 07 传递信息
 */
public class NumWays {

    public static void main(String[] args) {
        System.out.println(numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
    }

    /**
     * 动态规划
     * dp[i][j]经过i轮到达第j个小朋友的方案
     *
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public static int numWays(int n, int[][] relation, int k) {
        // 经过
        int[][] dp = new int[k + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= relation.length; j++) {
                int a = relation[j - 1][1], b = relation[j - 1][0];
                dp[i][a] += dp[i - 1][b];
            }
        }
        return dp[k][n-1];
    }
}
