package com.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCP 51 - 烹饪料理
 */
public class PerfectMenu {

    public static void main(String[] args) {
        System.out.println(perfectMenu(
                new int[]{3, 2, 4, 1, 2},
                new int[][]{{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}},
                new int[][]{{3, 2}, {2, 4}, {7, 6}}, 5));

//        System.out.println(perfectMenu(
//                new int[]{0, 0, 15, 10, 18},
//                new int[][]{{6, 6, 2, 6, 9}, {8, 10, 15, 12, 20}, {4, 9, 18, 19, 1}, {3, 1, 13, 0, 19}, {6, 15, 7, 6, 15}, {20, 3, 12, 3, 0}, {6, 5, 8, 13, 1}, {7, 0, 4, 8, 9}},
//                new int[][]{{16, 9}, {10, 8}, {16, 16}, {11, 1}, {0, 0}, {14, 2}, {8, 12}, {6, 9}}, 8));
    }

    /**
     * 1 1 0 1 2
     * 2 1 4 0 0
     * 3 2 4 1 0
     * m[j]: 表示食材数量
     * c[i][j]: 表示煮对应料理需要对应食材的数量
     * a[i] = [x, y]: 表示第 i 道料理的美味度 x ,饱腹度 y
     * y >= limit Max(x)
     *
     * @param materials
     * @param cookbooks
     * @param attribute
     * @param limit
     * @return
     */
    public static int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {

        // 目前食材可以满足的料理组合
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[cookbooks.length];
        back(materials, cookbooks, visited, result, new ArrayList<>());
        int max = -1;
        for (List<Integer> list : result) {
            int temp = 0;
            int tempLimit = 0;
            for (Integer x : list) {
                tempLimit += attribute[x][1];
                temp += attribute[x][0];
            }
            if (tempLimit >= limit) {
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static void back(int[] m, int[][] c, boolean[] visited, List<List<Integer>> result, List<Integer> list) {
        if (!list.isEmpty()) {
            result.add(new ArrayList<>(list));
        }
        int l = c.length;
        for (int i = 0; i < l; i++) {
            if (visited[i]) {
                continue;
            }

            boolean isNotCook = checkIsNotCook(i, m, c, list);
            if (isNotCook) {
                continue;
            }
            visited[i] = true;
            list.add(i);
            back(m, c, visited, result, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 新加入的料理是否会超过目前的食材数量
     *
     * @param i    第 i 道料理
     * @param m    食材
     * @param c    料理集合
     * @param list 已加入的料理
     * @return
     */
    public static boolean checkIsNotCook(int i, int[] m, int[][] c, List<Integer> list) {
        int[] all = Arrays.copyOf(c[i], c[i].length);
        for (int a = 0; a < all.length; a++) {
            if (all[a] > m[a]) {
                return true;
            }
            for (Integer d : list) {
                all[a] = all[a] + c[d][a];
                if (all[a] > m[a]) {
                    return true;
                }
            }

        }
        return false;
    }
}
