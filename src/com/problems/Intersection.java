package com.problems;

import java.util.*;

/**
 * @description 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * @Date 2022/5/19 19:41
 * @Created by lianhai.deng
 */
public class Intersection {

    public static void main(String[] args) {
        intersection(new int[]{4, 9, 2, 1}, new int[]{9, 24, 9, 4});
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums1) {
            if (!list.contains(x) && Arrays.stream(nums2).filter(i -> Objects.equals(i, x)).count() > 0) {
                list.add(x);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
