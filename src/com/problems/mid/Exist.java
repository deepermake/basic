package com.problems.mid;

/**
 * 79 - 单词搜索
 */
public class Exist {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    /**
     * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        // 遍历每一个节点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = back(board, word, 0, i, j);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param arr   源数组
     * @param word  目标
     * @param index 目标索引
     * @param i
     * @param j
     */

    public static boolean back(char[][] arr, String word, int index, int i, int j) {

        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || word.charAt(index) != arr[i][j]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        arr[i][j] += 256;
        boolean flag =
                back(arr, word, index + 1, i + 1, j) || back(arr, word, index + 1, i - 1, j) ||
                        back(arr, word, index + 1, i, j - 1) || back(arr, word, index + 1, i, j + 1);
        arr[i][j] -= 256;
        return flag;
    }
}
