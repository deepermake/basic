package com.interviewer;

/**
 * 面试题 01.07 旋转矩阵
 */
public class Rotate {

    public static void main(String[] args) {

        // int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(matrix);
    }

    public static void rotate(int[][] matrix) {
        int l = matrix[0].length / 2;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < matrix[i].length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l - j + 1][i];
                matrix[l - j + 1][i] = matrix[l - i + 1][l - j + 1];
                matrix[l - i + 1][l - j + 1] = matrix[j][l - i + 1];
                matrix[j][l - i + 1] = temp;
            }
        }
    }


}
