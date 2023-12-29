package com.problems.str.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 242 - 有效的字母异位词
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("ab", "ab"));
        System.out.println(isAnagram("aacc", "ccac"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<String, Integer> mapS = new HashMap<>();
        Map<String, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String strS = String.valueOf(s.charAt(i));
            String strT = String.valueOf(t.charAt(i));

            Integer countS = 0;
            Integer countT = 0;
            if (mapS.containsKey(strS)) {
                countS = mapS.get(strS);
                countS++;
            }
            mapS.put(strS, countS);

            if (mapT.containsKey(strT)) {
                countT = mapT.get(strT);
                countT++;
            }
            mapT.put(strT, countT);

        }

        if (!Objects.equals(mapS.size(), mapT.size())) {
            return false;
        }

        for (String key : mapS.keySet()) {
            if (!Objects.equals(mapS.get(key), mapT.get(key))) {
                return false;
            }
        }
        return true;
    }


}
