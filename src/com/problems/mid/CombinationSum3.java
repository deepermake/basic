package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 216 - 组合总和 III
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }

    /**
     * 1 ~ 9 中 相加为n的k个数
     *
     * @param k
     * @param n
     * @return
     */
    public static int sum = 0;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[10];
        back(list, visited, new ArrayList<>(), k, n);
        return list;
    }

    public static void back(List<List<Integer>> list, boolean[] visited, List<Integer> path, int k, int n) {
        if (path.size() == k && sum == n) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (visited[i] || sum + i > n) {
                continue;
            }
            if (!path.isEmpty() && path.get(path.size() - 1) > i) {
                continue;
            }
            visited[i] = true;
            path.add(i);
            sum += i;
            back(list, visited, path, k, n);
            visited[i] = false;
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
