package com.problems.mid;

import java.util.Arrays;
import java.util.List;

public class MinBitwiseArray {

    public static void main(String[] args) {
        List<Integer> arrs = Arrays.asList(11, 13, 19);
        int[] result = minBitwiseArray(arrs);
        System.out.println(result);
    }

    public static int[] minBitwiseArray(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int m = nums.get(i);
            // 暴力破解
//            for (int j = m / 2; j < m; j++) {
//                if ((j | (j + 1)) == m) {
//                    arr[i] = j;
//                    break;
//                }
//            }
//            if (arr[i] == 0) {
//                arr[i] = -1;
//            }
            // 位运算
            if (m % 2 == 0) {
                arr[i] = -1;
                continue;
            }
            for (int j = 1; j < 32; j++) {
                if ((m >> j & 1) == 0) {
                    arr[i] = m ^ (1 << (j - 1));
                    break;
                }
            }

        }
        return arr;
    }
}
