package com.interviewer;

import java.util.*;

public class BestSeqAtIndex {
    public static void main(String[] args) {
        System.out.println(bestSeqAtIndex2(new int[]{1, 2, 3, 2, 3, 2}, new int[]{7, 3, 3, 4, 5, 7}));
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
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[l];
        dp[0] = 1;
        int max = 1;
        return max;
    }
}
