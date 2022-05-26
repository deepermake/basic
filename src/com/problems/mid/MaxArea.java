package com.problems.mid;


import sun.nio.cs.ext.MacHebrew;

/**
 * Description: 11. 盛最多水的容器
 * Link:    https://leetcode.cn/problems/container-with-most-water/
 * Author:   lianhai.deng
 * Date:     2022/5/26 23:12
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2,3,4,5,6}));
        // System.out.println(maxAreaDp(new int[]{1,2,3,4,5,6}));
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
        int i = 0, j = 1;
        int max = Math.min(height[i], height[j]);
        for (int k = 2; k < height.length; k++) {
            int area = (j - i) * Math.min(height[i], height[j]);
            int areaKI = (k - i) * Math.min(height[k], height[i]);
            int areaKJ = (k - j) * Math.min(height[k], height[j]);
            if (areaKJ > area && areaKJ > areaKI) {
                i = j;
                j = k;
                max = areaKJ;
            } else if (areaKI > areaKJ && areaKI > area) {
                j = k;
                max = areaKI;
            }
        }
        return max;
    }
}
