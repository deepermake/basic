package com.problems;

/**
 * @author lianhai.deng
 * @description 合并两个有序数组 https://leetcode.cn/problems/merge-sorted-array/
 * @createTime 2022/5/17 15:09
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        merge(new int[]{0}, 0, new int[]{2}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m - 1;
        int b = n - 1;

        int k = m + n - 1;

        while (a >= 0 || b >= 0) {
            if (a >= 0 && b >= 0 && nums1[a] < nums2[b]) {
                nums1[k--] = nums2[b--];
            } else if (a >= 0) {
                nums1[k--] = nums1[a--];
            } else if (b >= 0) {
                nums1[k--] = nums2[b--];
            }
        }
    }

}
