package com.problems.easy;

/**
 * 942 增减字符串匹配
 */
public class DiStringMatch {

    public static void main(String[] args) {
        diStringMatch("III");
    }

    public static int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int max = s.length();
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = min;
                res[i + 1] = max;
                min++;
                continue;
            }
            res[i] = max;
            res[i + 1] = min;
            max--;

        }
        return res;
    }
}
