package com.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1863 找出所有子集的异或总和再求和
 */
public class SubsetXORSum {

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    public static int subsetXORSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        back(nums, visited, new ArrayList<>(), list, 0);
        for (List<Integer> l : list) {
            result += xorSum(l);
        }
        return result;
    }

    public static void back(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res, int index) {
        if (!path.isEmpty()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            back(nums, visited, path, res, i);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    public static int xorSum(List<Integer> path) {
        if (path.size() == 1) {
            return path.get(0);
        }
        int result = 0;
        for (Integer x : path) {
            result ^= x;
        }
        return result;
    }
}
