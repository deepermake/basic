package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 526 - 优美的排列 （回溯）
 */
public class CountArrangement {

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
        System.out.println(countArrangement(4));
    }


    public static int countArrangement(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        back(n, path, result);
        return result.size();
    }

    public static void back(int n, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (path.contains(i)) {
                continue;
            }
            int l = path.size() + 1;
            if (i % l != 0 && l % i != 0) {
                continue;
            }
            path.add(i);
            back(n, path, result);
            path.remove(path.size() - 1);

        }
    }


}
