package com.problems.easy;

import java.util.Objects;

/**
 * 682 - 棒球比赛
 */
public class CalPoints {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints(new String[]{"1"}));
        System.out.println(calPoints(new String[]{"5", "2", "2", "C", "C", "D", "+"}));
    }

    /**
     * ["5","2","2","C","C","D","+"]
     * [5, 2, 0, 2,]
     * <p>
     * 遇到C时如何处理，C是使前一个无效
     *
     * @param operations
     * @return
     */

    public static int calPoints(String[] operations) {
        int[] result = new int[operations.length];
        int k = 0;

        for (int i = 0; i < operations.length; i++) {

            if (Objects.equals(operations[i], "C")) {
                k = k - 1;
                result[k] = 0;
                continue;
            }

            if (Objects.equals(operations[i], "D")) {
                result[k] = result[k - 1] * 2;
                k++;
                continue;
            }

            if (Objects.equals(operations[i], "+")) {
                result[k] = result[k - 1] + result[k - 2];
                k++;
                continue;
            }

            result[k++] = Integer.parseInt(operations[i]);
        }

        int resultScore = 0;
        for (int index : result) {
            resultScore += index;
        }
        return resultScore;
    }
}
