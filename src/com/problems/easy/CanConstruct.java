package com.problems.easy;

/**
 * 383 - 赎金信
 */
public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']--;
            if (arr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
