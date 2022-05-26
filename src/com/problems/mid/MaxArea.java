package com.problems.mid;


/**
 * Description: 11. 盛最多水的容器
 * Link:    https://leetcode.cn/problems/container-with-most-water/
 * Author:   lianhai.deng
 * Date:     2022/5/26 23:12
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int k = i + 1; k < height.length; k++) {
                max = Math.max(max, (k - i) * Math.min(height[i], height[k]));
            }
        }
        return max;
    }

    public static int maxAreaDp(int[] height) {
        int max = 0;
        return max;
    }
}
