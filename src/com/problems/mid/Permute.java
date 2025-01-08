package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 - 全排列
 */
public class Permute {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
        permute(new int[]{0, 1});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(nums, list, result);
        return result;
    }

    public static void back(int[] nums, List<Integer> list, List<List<Integer>> result) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (list.contains(nums[j])) {
                continue;
            }
            list.add(nums[j]);
            back(nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}
