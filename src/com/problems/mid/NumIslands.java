package com.problems.mid;

/**
 * 200 - 岛屿数量
 */
public class NumIslands {

    public static void main(String[] args) {
        // System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        // System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '1'}}));
        // System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
        // System.out.println(numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}));

        System.out.println(numIslands(new char[][]{{'0', '1', '0'}, {'1', '0', '1'}, {'0', '1', '0'}}));
    }

    public static int numIslands(char[][] grid) {
        int landsNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    landsNum++;
                }
            }
        }
        return landsNum;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '2' || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '2';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }
}
