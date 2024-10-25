package com.interviewer;

import java.util.Objects;

public class OneEditAway {

    public static void main(String[] args) {
        System.out.println(oneEditAway("p", "l"));
    }

    public static boolean oneEditAway(String first, String second) {

        if (Objects.equals(first, second)) {
            return true;
        }



        return false;

    }
}
