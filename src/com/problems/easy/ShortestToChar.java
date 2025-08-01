package com.problems.easy;

/**
 * 821 -字符的最短距离
 */
public class ShortestToChar {
    public static void main(String[] args) {
        shortestToChar("loveleetcode", 'e');
    }

    public static int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int index = s.indexOf(c, 0);
        for (int i = 0; i < s.length(); i++) {
            int temp = s.indexOf(c, i);
            if (s.charAt(i) == c) {
                index = temp;
                res[i] = 0;
                continue;
            }
            if (temp == -1) {
                res[i] = Math.abs(i - index);
                continue;
            }
            res[i] = Math.min(Math.abs(i - index), Math.abs(i - temp));
        }
        return res;

    }
}
