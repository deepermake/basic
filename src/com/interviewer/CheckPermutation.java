package com.interviewer;

/**
 * 面试题 01.02 判定是否互为字符重排
 */
public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(checkPermutation("def", "aei"));
//        System.out.println(checkPermutation("abc", "bad"));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
