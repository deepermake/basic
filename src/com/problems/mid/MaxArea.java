package com.problems.mid;


/**
 * Description: 11. 盛最多水的容器
 * Link:    https://leetcode.cn/problems/container-with-most-water/
 * Author:   lianhai.deng
 * Date:     2022/5/26 23:12
 */
public class MaxArea {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,7,9,2,8,10};

        System.out.println(maxArea(arr));
        System.out.println(maxAreaDp(arr));
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
        int i = 0, j = height.length - 1;
        int max = j * Math.min(height[i], height[j]);
        while (i < height.length - 1 && j > i) {
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
        }
        return max;
    }
}
