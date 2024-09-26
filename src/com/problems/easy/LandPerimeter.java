package com.problems.easy;

/**
 * 463 - 岛屿的周长
 */
public class LandPerimeter {

    public static void main(String[] args) {
        // System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        // System.out.println(islandPerimeter(new int[][]{{1}}));
        System.out.println(islandPerimeter(new int[][]{{1, 1}, {0, 1}, {1, 1}}));
    }


    /**
     * 暴力破解 - 列举每个岛屿点的情况
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // 判断该点的情况
                // 横向
                // 该点为上临界点
                if (i == 0) {
                    if (1 == grid.length) {
                        result += 2;
                    } else {
                        if (grid[i + 1][j] == 0) {
                            result += 2;
                        } else {
                            result += 1;
                        }
                    }
                } else if (i == grid.length - 1) {
                    if (grid[i - 1][j] == 0) {
                        result += 2;
                    } else {
                        result += 1;
                    }
                } else {
                    if (grid[i - 1][j] == 0) {
                        result++;
                    }
                    if (grid[i + 1][j] == 0) {
                        result++;
                    }

                }

                // 纵向
                if (j == 0) {
                    if (grid[i].length == 1) {
                        result += 2;
                    } else {
                        if (grid[i][j + 1] == 0) {
                            result += 2;
                        } else {
                            result += 1;
                        }
                    }
                } else if (j == grid[i].length - 1) {
                    if (grid[i][j - 1] == 0) {
                        result += 2;
                    } else {
                        result += 1;
                    }
                } else {

                    if (grid[i][j + 1] == 0) {
                        result++;
                    }
                    if (grid[i][j - 1] == 0) {
                        result++;
                    }
                }

            }
        }
        return result;
    }


    public static int islandPerimeterDfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public static int dfs(int[][] grid, int x, int y) {

        return dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
