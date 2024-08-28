package com.problems.str.mid;

/**
 * 75 - 颜色分类
 */
public class SortColors {

    public static void main(String[] args) {
        sortColorNoExchange(new int[]{2, 0, 0, 1, 2, 1, 0, 0, 0, 2, 1, 1, 2, 2, 2, 0, 2, 0, 0, 2, 1, 1, 0});
        //sortColors(new int[]{1});
    }

    public static void sortColors(int[] nums) {

        int zeroIndex = 0, oneIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex] = temp;

                zeroIndex++;
                oneIndex = zeroIndex;

            }

            if (nums[i] == 1) {
                while (nums[i] == nums[oneIndex] && oneIndex < i) {
                    oneIndex = oneIndex + 1;
                }
                int temp = nums[i];
                nums[i] = nums[oneIndex];
                nums[oneIndex] = temp;
                oneIndex++;
            }
        }

    }

    public static void sortColorNoExchange(int[] nums) {
        int zeroIndex = 0, oneIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = 2;
            if (temp < 2) {
                nums[oneIndex++] = 1;
            }
            if (temp < 1) {
                nums[zeroIndex++] = 0;
            }
        }
    }
}
