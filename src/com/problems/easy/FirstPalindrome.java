package com.problems.easy;


/**
 * 2108 - 找出数组中的第一个回文字符串
 */
public class FirstPalindrome {

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc", "caac", "ada", "racecar", "cool"}));
    }

    public static String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])){
                return words[i];
            }
        }
        return "";
    }

    public static boolean isPalindrome(String s) {
        int l = s.length() / 2;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
