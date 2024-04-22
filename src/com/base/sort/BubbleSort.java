package com.base.sort;

/**
 * Description: 冒泡排序
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/5/31 17:19
 */
public class BubbleSort {



    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 2, 5, 0, 2};
        bubbleSort(arr);
    }


    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
