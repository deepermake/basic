package com.problems.easy.array;

/**
 * Description: 283. 移动零
 * Link:     https://leetcode.cn/problems/move-zeroes/
 * Author:   lianhai.deng
 * Date:     2022/5/27 08:28
 */
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,1});
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1 && nums[0] == 0){
            return;
        }
        int i = 0, j = 1;
        while (j < nums.length){
            if (nums[i] != 0){
                i++;
                j++;
                continue;
            }
            if (nums[j] != 0){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;j++;
                continue;
            }
            j++;
        }
    }
}
