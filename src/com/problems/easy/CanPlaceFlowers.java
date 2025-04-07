package com.problems.easy;

/**
 * 605 - 种花问题
 */
public class CanPlaceFlowers {


    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }


    /**
     * 解题思路
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                continue;
            }
            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;
    }
}
