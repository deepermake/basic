package com.interviewer;

import java.util.*;

/**
 * 面试题 01.08 零矩阵
 */
public class SetZeroes {

    public static void main(String[] args) {
        // setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        // setZeroes(new int[][]{{0, 1, 0}, {1, 0, 1}, {1, 1, 1}});
        setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

    /**
     * 借助HashMap实现
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }

                if (Objects.isNull(map.get(i)) || !map.get(i).contains(j)) {
                    setZeroe(matrix, map, i, j);
                }
            }
        }
    }

    public static void setZeroe(int[][] matrix, HashMap<Integer, List<Integer>> map, Integer x, Integer y) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y] == 0) {
                continue;
            }
            matrix[i][y] = 0;
            List<Integer> list = map.get(i);
            if (Objects.isNull(map.get(i))) {
                list = new ArrayList<>(y);
            }
            list.add(y);
            map.put(i, list);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[x][j] == 0) {
                continue;
            }
            matrix[x][j] = 0;
            List<Integer> list = map.get(x);
            if (Objects.isNull(map.get(x))) {
                list = new ArrayList<>();
            }
            list.add(j);
            map.put(x, list);
        }

    }
}
