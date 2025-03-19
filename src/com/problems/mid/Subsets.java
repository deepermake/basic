package com.problems.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78 - 子集
 */
public class Subsets {

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // back(nums, result, new ArrayList<>());
        back(nums, result, new ArrayList<>(), 0);
        return result;

    }

    /**
     *
     * @param nums
     * @param result
     * @param path
     */
    public static void back(int[] nums, List<List<Integer>> result, List<Integer> path) {

        result.add(new ArrayList<>(path));
        if (path.size() == nums.length){
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }

            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]){
                continue;
            }

            path.add(nums[i]);
            back(nums, result, path);
            path.remove(path.size() - 1);
        }
    }


    /**
     *
     * @param nums
     * @param result
     * @param path
     * @param index
     */
    public static void back(int[] nums, List<List<Integer>> result, List<Integer> path, int index) {

        result.add(new ArrayList<>(path));
        if (path.size() == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            back(nums, result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
