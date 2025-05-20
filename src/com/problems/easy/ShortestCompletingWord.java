package com.problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestCompletingWord {

    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String s = licensePlate.toLowerCase();
        boolean[] res = new boolean[words.length];
        Arrays.fill(res, true);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || s.charAt(i) < 97 || s.charAt(i) > 122) {
                continue;
            }
            if (set.contains(s.charAt(i))) {
                continue;
            }
            set.add(s.charAt(i));
            char str = s.charAt(i);
            int num = (int) s.chars().filter(c -> c == str).count();
            for (int j = 0; j < words.length; j++) {
                if (!res[j]){
                    continue;
                }
                int count = (int) words[j].toLowerCase().chars().filter(c -> c == str).count();
                res[j] = count >= num;
            }
        }

        String result = "";
        for (int i = 0; i < res.length; i++) {
            if (!res[i]) {
                continue;
            }
            if (result.isEmpty() || result.length() > words[i].length()) {
                result = words[i];
            }
        }

        return result;
    }
}
