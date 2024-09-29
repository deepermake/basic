package com.problems.easy;

/**
 * 1668 - 最大重复字符串
 */
public class MaxRepeating {

    public static void main(String[] args) {
        // System.out.println(maxRepeating("aaabaaabaaabaaaaba", "aaab"));
        System.out.println(maxRepeating("ababc", "ab"));
    }

    public static int maxRepeating(String sequence, String word) {
        int max = 0;
        int len = word.length();
        String temp = word;
        for (int i = 0; i * len <= sequence.length(); i++) {
            if (sequence.contains(temp)) {
                max = i+1;
            }
            temp = temp.concat(word);
        }
        return max;
    }
}
