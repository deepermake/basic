package com.interviewer;

/**
 * 面试题 01.07 旋转矩阵
 */
public class Rotate {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int l = matrix[0].length / 2;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < matrix[i].length - (i * 2); j++) {

            }
        }

    }


}
