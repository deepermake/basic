package com.interviewer;

import java.util.Objects;

public class OneEditAway {

    public static void main(String[] args) {
        System.out.println(oneEditAway("ab", "ba"));
    }

    public static boolean oneEditAway(String first, String second) {

        if (Objects.equals(first, second)) {
            return true;
        }

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        int time = 0;
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (j < second.length() - 1 && first.charAt(i) == second.charAt(j + 1)) {
                time++;
                i++;
                j += 2;
                continue;
            }

            if (i < first.length() - 1 && first.charAt(i+1) == second.charAt(j)){
                time++;
                i += 2;
                j++;
                continue;
            }
            time += 2;
        }

        return time <= 1;


    }
}
