package com.problems.easy.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class findTheDifference {
    public static void main(String[] args) {

        // todo
        System.out.println(findTheDifference("abcd", "abcda"));
    }

    public static char findTheDifference(String s, String t) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - 'a' + 1);
        }
        for (int j = 0; j<t.length(); j++){
            if (!list.contains(t.charAt(j) - 'a' + 1)){
                return t.charAt(j);
            }
            list.remove(list.indexOf(t.charAt(j) - 'a' + 1));
        }
        return 'a';
    }
}
