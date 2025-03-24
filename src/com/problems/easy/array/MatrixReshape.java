package com.problems.easy.array;

/**
 * 566 - 重塑矩阵
 */
public class MatrixReshape {

    public static void main(String[] args) {
        // matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        matrixReshape(new int[][]{{1, 2, 3, 4}, {3, 4, 5, 6}}, 4, 2);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // 列
        int col = mat[0].length;
        // 行
        int row = mat.length;

        if (col * row != r * c){
            return mat;
        }

        int[][] result = new int[r][c];
        int rr = 0;
        int cc = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (cc == c) {
                    cc = 0;
                    rr++;
                }
                result[rr][cc++] = mat[i][j];
            }
        }
        return result;
    }
}
