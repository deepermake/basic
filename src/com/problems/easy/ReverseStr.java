package com.problems.easy;

public class ReverseStr {
    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefg", 2));

    }

    public static String reverseStr(String s, int k) {
        if (s.length() < 2 * k) {
            return s;
        }

        int start = 0, end = 2 * k;
        StringBuilder result = new StringBuilder();
        int left = 2 * k;
        while (left < s.length()) {

            result.append(new StringBuffer(s.substring(start, k)).reverse());
            result.append(s, start + k, 2 * k);

            left = s.length() - end;
            if (left == 0) {
                break;
            }

            if (left > 2 * k) {
                start = end;
                end += 2 * k;
                continue;
            }

            if (left >= k) {
                result.append(new StringBuffer(s.substring(start + k, k)).reverse());
            }

            if (left < k) {
                result.append(new StringBuffer(s.substring(end)).reverse());
            }
            break;
        }
        return result.toString();
    }
}
