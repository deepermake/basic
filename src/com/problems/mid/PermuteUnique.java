package com.problems.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 47 - 全排列II
 */
public class PermuteUnique {

    public static void main(String[] args) {
        // permuteUnique(new int[]{1, 1, 2});
        permuteUnique(new int[]{1});
    }

    /**
     * 解题思路 回溯
     * 回溯的结束条件，list.size == nums.length
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1){
            List<Integer> list = Collections.singletonList(nums[0]);
            result.add(list);
            return result;
        }
        Arrays.sort(nums);
        boolean[] arr = new boolean[nums.length];
        back(result, new ArrayList<>(), nums, arr);
        return result;
    }

    /**
     * 回溯
     * <p>
     * {1,1,2}
     * 比如{1,1}已经使用过，再次{1,1}时，如何判断{1,1}是否已经使用过
     * {1，1，2}
     * 使用boolean数组arr来表示元素是否使用
     *
     * @param result 结果
     * @param list   当前集合
     * @param nums   目标数组
     * @param arr
     */
    public static void back(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] arr) {
        // 回溯中断条件
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (arr[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !arr[i - 1]) {
                continue;
            }
            arr[i] = true;
            list.add(nums[i]);
            back(result, list, nums, arr);
            arr[i] = false;
            list.remove(list.size() - 1);

        }

    }

}
