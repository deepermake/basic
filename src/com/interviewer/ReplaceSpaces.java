package com.interviewer;

/**
 * 面试题 01.03 URL化
 */
public class ReplaceSpaces {

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith  ", 13));

    }

    public static String replaceSpaces(String s, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
