package com.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角II
 */
public class GetRow {

    public static void main(String[] args) {
        getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0){
            list.add(1);
            return list;
        }

        int[][] arr = new int[rowIndex+1][rowIndex+1];
        arr[0][0] = 1;
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }

                if (i == rowIndex){
                    list.add(arr[i][j]);
                }
            }
        }

        return list;
    }
}
