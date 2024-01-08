package com.problems.str.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 290 - 单词规律
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("a", "dog "));
    }

    public static boolean wordPattern(String pattern, String s) {
        if (pattern.length() == 1 && s.length() == 1) {
            return true;
        }
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(arr[i])) {
                map.put(pattern.charAt(i), arr[i]);
                continue;
            }

            String result = map.get(pattern.charAt(i));
            if (!Objects.equals(result, arr[i])) {
                return false;
            }
        }
        return true;
    }
}
