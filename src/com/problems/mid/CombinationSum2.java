package com.problems.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40 - 组合总和II
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] arr = new boolean[candidates.length];
        back(list, new ArrayList<>(), candidates, arr, target, 0);
        return list;
    }

    public static void back(List<List<Integer>> list, List<Integer> path, int[] nums, boolean[] arr, int target, int sum) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !arr[i - 1]) {
                continue;
            }

            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
                continue;
            }

            if (sum + nums[i] > target) {
                return;
            }

            path.add(nums[i]);
            arr[i] = true;
            sum += nums[i];
            back(list, path, nums, arr, target, sum);
            path.remove(path.size() - 1);
            arr[i] = false;
            sum -= nums[i];
        }
    }
}
