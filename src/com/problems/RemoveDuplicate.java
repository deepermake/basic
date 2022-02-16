package com.problems;

/**
 * @description 删除有序数组中的重复项
 *              移除元素 https://leetcode-cn.com/problems/remove-element/
 * @Date 2022/2/16 13:29
 * @Created by lianhai.deng
 */

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,3,3,4};
        // int k = removeDuplicates(nums);
        int k = removeElement(nums, 1);
        System.out.println(nums);


    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int a = 1;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] != nums [i+1]){
                nums[a] = nums[i+1];
                a++;
            }
        }
        return a;
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0 || (length == 1 && nums[0] == val)) {
            return 0;
        }
        int a = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val){
                nums[a] = nums[i];
                a++;
            }
        }
        return a;
    }
}
