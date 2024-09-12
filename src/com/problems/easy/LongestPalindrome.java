package com.problems.easy;

import java.util.HashSet;

/**
 * 409 - 最长回文串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        // System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome2("abccccdd"));
        System.out.println(longestPalindrome2("a"));
    }

    public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                result += 2;
                set.remove(c);
                continue;
            }
            set.add(c);
        }
        return set.isEmpty() ? result : result + 1;
    }

    public static int longestPalindrome2(String s) {
        int[] index = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index[c]++;
        }
        int result = 0;
        boolean flag = false;
        for (int i : index) {
            if (i == 0) {
                continue;
            }
            result += (i / 2) * 2;
            flag = i % 2 == 1 || flag;
        }
        return flag ? result + 1 : result;
    }
}
