package com.problems;

/**
 * @description 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @Date 2022/3/18 17:19
 * @Created by lianhai.deng
 */

public class SearchInsert {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 4, 5};

        System.out.println(searchInsert(arr, 3));
    }


    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;

        if (len == 1) {
            return 0;
        }
        int startIndex = len / 2;
        int i = 0;
        int k = startIndex;


        return i;
    }

}
