package com.problems.easy;

import java.util.*;

/**
 * 884 - 两句话中的不常见单词
 */
public class UncommonFromSentences {

    public static void main(String[] args) {
        uncommonFromSentences("this apple is sweet", "this apple is sour");
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(s1.split(" ")));
        arr.addAll(Arrays.asList(s2.split(" ")));
        List<String> result = new ArrayList<>();
        for (String s : arr) {
            if (arr.indexOf(s) == arr.lastIndexOf(s)) {
                result.add(s);
            }
        }
        return result.toArray(new String[0]);

    }
}
