package com.problems;

/**
 * @description 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @Date 2022/3/18 17:19
 * @Created by lianhai.deng
 */

public class SearchInsert {

    public static void main(String[] args) {

        int[] arr = {1,3,5,6};

        System.out.println(searchInsert(arr, 2));
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if (target <= nums[left]) {
            return left;
        }
        if (target >= nums[right]) {
            return nums.length;
        }

        if (right - left == 1) {
            return 1;
        }

        while (left < right - 1) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
        }
        return mid;
    }

}
