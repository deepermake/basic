package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 77 - 组合
 */
public class Combine {

    public static void main(String[] args) {
        combine(4, 1);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(1, n, k, list, result);
        return result;
    }

    /**
     * 解题思路
     * 1、终止回溯的条件，当数组的长度等于k时，返回
     * 2、已知条件，当前的位置，数组的长度，中断的条件为k
     *
     * @param i
     * @param k
     * @param list
     * @param result
     */
    public static void back(int i, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            back(j + 1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }


}
