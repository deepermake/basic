package com.problems.easy.array;

import java.util.Arrays;

/**
 * Description: 350. 两个数组的交集 II
 * Link:        https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * Author:      lianhai.deng
 * Date:        2022/5/28 14:15
 */
public class IntersectTwo {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        intersect(nums1, nums2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, len = 0;

        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                arr[len++] = nums1[i++];
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOfRange(arr, 0, len);
    }
}
