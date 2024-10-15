package com.interviewer;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.04 回文排列
 */
public class CanPermutePalindrome {

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));
    }

    public static boolean canPermutePalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() || set.size() == 1;
    }
}
