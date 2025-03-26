package com.problems.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90 - 子集II
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        subsetsWithDup(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];
        Arrays.sort(nums);
        back(res, new ArrayList<>(), nums, arr, 0);
        return res;
    }

    /**
     * 回溯
     */
    public static void back(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] arr, int index) {

        res.add(new ArrayList<>(path));
        if (path.size() == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (arr[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !arr[i - 1]) {
                continue;
            }
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]){
                continue;
            }
            arr[i] = true;
            path.add(nums[i]);
            back(res, path, nums, arr, index + 1);
            arr[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
