package com.base;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 回溯算法
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/7/21 15:05
 */
public class BackTrack {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<Integer> track = new LinkedList<>();
        List<List<Integer>> res = backTrack(nums, track);
        System.out.println(res);
    }

    private static List<List<Integer>> result = new LinkedList<>();

    private static List<List<Integer>> backTrack(int[] nums, List<Integer> track){
        if (track.size() == nums.length){
            result.add(new LinkedList<>(track));
            return null;
        }
        for (int i = 0; i<nums.length;i++){
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.remove(track.size() - 1);
        }
        return result;
    }
}
