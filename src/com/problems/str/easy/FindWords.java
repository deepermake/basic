package com.problems.str.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 500 - 键盘行
 */
public class FindWords {

    // qwertyuiop
    // asdfghjkl
    // zxcvbnm

    public static void main(String[] args) {
        System.out.printf(findWordsTwo(new String[]{"Hello", "Alaska", "Dad", "Peace"}).toString());
        System.out.printf(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}).toString());
    }

    public static String[] findWords(String[] words) {

        List<String> list = new ArrayList<>();

        HashSet<String> setQP = new HashSet<>(Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
        HashSet<String> setAL = new HashSet<>(Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l"));
        HashSet<String> setZM = new HashSet<>(Arrays.asList("z", "x", "c", "v", "b", "n", "m"));

        for (String s : words) {
            HashSet<String> sSet = new HashSet<>(Arrays.asList(s.toLowerCase().split("")));
            if (setQP.containsAll(sSet) || setAL.containsAll(sSet) || setZM.containsAll(sSet)) {
                list.add(s);
            }
        }
        return list.toArray(new String[0]);
    }

    public static String[] findWordsTwo(String[] words) {
        String[] inputArr = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] indexArr = new int[26];
        for (int i = 0; i < inputArr.length; i++) {
            for (Character c : inputArr[i].toCharArray()) {
                indexArr[c - 'a'] = i;
            }
        }
        List<String> list = new ArrayList<>();
        loop:
        for (String s : words) {
            int tmp = indexArr[Character.toLowerCase(s.charAt(0)) - 'a'];
            for (Character ch : s.toCharArray()) {
                if (tmp != indexArr[Character.toLowerCase(ch) - 'a']) {
                    continue loop;
                }
            }
            list.add(s);
        }
        return list.toArray(new String[0]);
    }
}
