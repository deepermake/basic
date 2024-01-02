package com.problems.str.easy;

import java.util.Arrays;

/**
 * 389 - 找不同
 */
public class findTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("aaa", "aaab"));
    }

    public static char findTheDifference(String s, String t) {
        if (s.isEmpty()) {
            return t.charAt(0);
        }

        int[] arrS = new int[s.length()];
        int[] arrT = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            arrS[i] = s.charAt(i) - 'a';
        }
        for (int j = 0; j < t.length(); j++) {
            arrT[j] = t.charAt(j) - 'a';
        }
        Arrays.sort(arrS);
        Arrays.sort(arrT);

        for (int i = 0; i < s.length(); i++) {
            if (arrS[i] == arrT[i]) {
                continue;
            }
            return (char) (arrT[i] + 'a');
        }

        return (char) (arrT[s.length()] + 'a');
    }
}
