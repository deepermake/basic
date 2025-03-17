package com.problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 506 相对名次
 */
public class FindRelativeRanks {

    public static void main(String[] args) {
        findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        findRelativeRanks(new int[]{10, 3, 8, 9, 4});
    }

    public static String[] findRelativeRanks(int[] score) {
        List<Integer> list = new ArrayList<>();
        String[] result = new String[score.length];
        String[] grade = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i : score) {
            list.add(i);
        }

        list = list.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < score.length; i++) {
            int index = list.indexOf(score[i]);
            index = list.size() - index;
            if (index < 4) {
                result[i] = grade[index - 1];
                continue;
            }
            result[i] = String.valueOf(index);
        }

        return result;
    }
}
