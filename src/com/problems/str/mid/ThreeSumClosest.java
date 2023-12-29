package com.problems.str.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16 - 最接近的三数之和
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
//        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 2));
//        System.out.println(threeSumClosest(new int[]{1, 5, 4,20,6,6,12}, 5));
//        System.out.println(threeSumClosest(new int[]{-100,-2,90,1,1,4,1000}, 100));
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        // 最接近的数据
        int result = Integer.MAX_VALUE;
        // 最接近的距离
        int closeDistance = result;

        for (int i = 0; i < nums.length - 2; i++) {
            // 固定一位，其他两位通过移动计算
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 当前值
                int currResult = nums[i] + nums[j] + nums[k];
                // 接近的距离
                int currDistance = Math.abs(currResult - target);
                // 距离为0,最接近
                if (currDistance == 0) {
                    return currResult;
                }

                if (currDistance < closeDistance) {
                    result = currResult;
                    closeDistance = currDistance;
                }

                if (closeDistance > target) {
                    k--;
                }

                if (closeDistance < target){
                    j++;
                }
            }
        }
        return result;


    }
}
