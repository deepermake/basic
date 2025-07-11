package com.problems.mid;

/**
 * 36 - 有效的数独
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!valid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * (1,3) = 1
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean valid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k == j) {
                continue;
            }
            if (board[i][j] == board[i][k]) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (k == i) {
                continue;
            }
            if (board[i][j] == board[k][j]) {
                return false;
            }
        }

        int endI = ((i / 3) + 1) * 3;
        int endJ = ((j / 3) + 1) * 3;

        for (int k = endI - 3; k < endI; k++) {
            for (int m = endJ - 3; m < endJ; m++) {
                if (k == i || m == j) {
                    continue;
                }
                if (board[k][m] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
