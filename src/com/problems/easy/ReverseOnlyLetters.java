package com.problems.easy;


/**
 * 917 - 仅仅反转字母
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("aa--bb"));
        System.out.println(reverseOnlyLetters("ab"));
        System.out.println(reverseOnlyLetters("c-"));
    }

    public static String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuilder builder = new StringBuilder(s);
        while (i < j) {
            char c = s.charAt(i);
            if (!isWord(c)) {
                i++;
                continue;
            }
            while (j > i) {
                char b = s.charAt(j);
                if (!isWord(b)) {
                    j--;
                    continue;
                }
                builder.replace(j, j + 1, String.valueOf(c));
                builder.replace(i, i + 1, String.valueOf(b));
                j--;
                i++;
                break;
            }


        }
        return builder.toString();
    }

    public static boolean isWord(Character c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }
}
