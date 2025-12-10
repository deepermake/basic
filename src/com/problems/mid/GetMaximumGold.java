package com.problems.mid;

/**
 * 1219 - 黄金矿工
 */
public class GetMaximumGold {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 6, 0}, {5, 8, 7}, {0, 9, 0}
        };
        GetMaximumGold object = new GetMaximumGold();
        System.out.println(object.getMaximumGold(arr));
    }

    int res = 0;

    public int getMaximumGold(int[][] grid) {

        boolean[][] visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                back(i, j, grid, visit, 0);
            }
        }
        return res;
    }

    public void back(int i, int j, int[][] grid, boolean[][] visit, int sum) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0 || visit[i][j]) {
            res = Math.max(sum, res);
            return;
        }
        sum = sum + grid[i][j];
        visit[i][j] = true;
        back(i + 1, j, grid, visit, sum);
        back(i, j + 1, grid, visit, sum);
        back(i - 1, j, grid, visit, sum);
        back(i, j - 1, grid, visit, sum);
        visit[i][j] = false;
    }
}
