package com.interviewer;

import java.util.*;

/**
 * 面试题 17.08 马戏团人塔
 */
public class BestSeqAtIndex {
    public static void main(String[] args) {
        // System.out.println(bestSeqAtIndex2(new int[]{1, 2, 3, 2, 3, 2}, new int[]{7, 3, 3, 4, 5, 7}));
        System.out.println(bestSeqAtIndex2(new int[]{8378, 8535, 8998, 3766, 648, 6184, 5506, 5648, 3907, 6773}, new int[]{9644, 849, 3232, 3259, 5229, 314, 5593, 9600, 6695, 4340}));
        // System.out.println(bestSeqAtIndex2(new int[]{65}, new int[]{100}));
    }

    /**
     * 解题思路 暴力破解，超时
     *
     * @param height
     * @param weight
     * @return
     */
    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int l = height.length;
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            List<Integer> remove = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    if (height[list.get(i)] > height[list.get(j)] && weight[list.get(i)] > weight[list.get(j)] && !remove.contains(list.get(i))) {
                        remove.add(list.get(i));
                    }
                }
            }
            list = remove;
            if (remove.isEmpty()) {
                break;
            }
            result++;
        }
        return result + 1;
    }


    /**
     * 解题思路
     * dp[i][1]
     * dp[i] = dp[i-1] + arr[i][1]
     *
     * @param height
     * @param weight
     * @return
     */
    public static int bestSeqAtIndex2(int[] height, int[] weight) {
        int l = height.length;
        int[][] arr = new int[l][2];
        for (int i = 0; i < l; i++) {
            arr[i][0] = height[i];
            arr[i][1] = weight[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> -o[0]));
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[l];
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }
        Arrays.sort(dp);
        return dp[l - 1] + 1;
    }
}
