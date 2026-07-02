package com.problems.easy;

import java.util.HashMap;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        // System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));

    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] str = new String[]{"!", "\\?", "'", ",", ";", "\\."};
        for (String s : str) {
            paragraph = paragraph.replaceAll(s, "");
        }
        for (String s : banned) {
            paragraph = paragraph.replace(s, "");
        }
        paragraph = paragraph.trim();
        String[] res = paragraph.split("");
        String result = " ";
        Integer max = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String re : res) {
            if (re.isEmpty()) {
                continue;
            }
            Integer count = map.get(re);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(re, count);
            if (count > max) {
                max = count;
                result = re;
            }
        }


        return result;
    }
}
