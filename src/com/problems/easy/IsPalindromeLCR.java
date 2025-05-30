package com.problems.easy;

/**
 * LCR 018 验证回文串
 */
public class IsPalindromeLCR {

    public static void main(String[] args) {
        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        // a = 97 z = 122
        while (i < j) {
            if (!isMatchChar(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isMatchChar(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean isMatchChar(char c) {
        // int num = c - '0';
        if (c >= 48 && c <= 57) {
            return true;
        }
        if (c >= 97 && c <= 122) {
            return true;
        }
        return false;
    }

}
