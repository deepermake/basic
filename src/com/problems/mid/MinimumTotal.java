package com.problems.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120 - 三角形最小路径和
 */
public class MinimumTotal {
    public static void main(String[] args) {
        Integer[] arrs2 = {2};
        Integer[] arrs3 = {3, 4};
        Integer[] arrs6 = {6, -5, -7};
        Integer[] arrs4 = {4, 1, 8, 3};
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(arrs2));
        lists.add(Arrays.asList(arrs3));
        lists.add(Arrays.asList(arrs6));
        lists.add(Arrays.asList(arrs4));
        System.out.println(minimumTotal(lists));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i + 1; j++) {

                int val = dp[i - 1][j] == null ? dp[i - 1][j - 1] : dp[i - 1][j];
                if (j - 1 >= 0) {
                    val = Math.min(val, dp[i - 1][j - 1]);
                }
                dp[i][j] = val + triangle.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            res = Math.min(res, dp[l - 1][i]);
        }
        return res;
    }

    // [
    // [-7],
    // [-2,  1],
    // [-5,-5, 9],
    // [-4, -5, 4, 4],
    // [-6, -6, 2, -1,-5],
    // [ 3,  7, 8, -3, 7, -9],
    // [-9, -1,-9,  6, 9,  0, 7],
    // [-7,  0,-6,-8,7,1,-4,9],
    // [-3,  2,-6,-9,-7,-6,-9,4,0],
    // [-8, -6,-3,-9,-2,-6,7,-5,0,7],
    // [-9, -1,-2,4,-2,4,4,-1,2,-5,5],
    // [ 1,  1,-6,1,-2,-4,4,-2,6,-6,0,6],
    // [-3, -3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]
    // ]
}
