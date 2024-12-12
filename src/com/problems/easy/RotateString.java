package com.problems.easy;

/**
 * 796 - 旋转字符串
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
        System.out.println(rotateString("ab", "ba"));
    }

    /**
     * 解题思路
     *
     * @param s
     * @param goal
     * @return
     */
    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (goal.equals(s.substring(i + 1).concat(s.substring(0, i + 1)))) {
                return true;
            }
        }

        return false;

    }

    /**
     * 天才的解法
     * @param s
     * @param goal
     * @return
     */
    public static boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s.concat(s).contains(goal));
    }
}
