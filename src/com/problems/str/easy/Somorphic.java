package com.problems.str.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 205-同构字符串
 */
public class Somorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("baba", "badc"));
        System.out.println(isIsomorphic("egg", "foo"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("abcd", "efgn"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(isIsomorphic("aaabba", "bbbbbb"));
        System.out.println(isIsomorphic("papap", "titii"));
    }

    /**
     * 1、映射关系都是单向的，a -> b   b -> c
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            String sStr = String.valueOf(s.charAt(i));
            String tStr = String.valueOf(t.charAt(i));
            if (map.containsKey(sStr) && !Objects.equals(map.get(sStr), tStr)) {
                return false;
            }
            if (!map.containsKey(sStr) && map.containsValue(tStr)) {
                return false;
            }
            map.put(sStr, tStr);
            i++;
        }
        return true;
    }
}
