package com.problems.easy;

import java.util.Arrays;

/**
 * 575 - 分糖果
 */
public class DistributeCandies {

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2}));
    }

    public static int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int typeCount = 1;
        for (int i = 0; i < candyType.length - 1; i++) {
            if (candyType[i] != candyType[i + 1]) {
                typeCount++;
            }
        }
        return Math.min(typeCount, candyType.length / 2);
    }
}
