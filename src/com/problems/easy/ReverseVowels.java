package com.problems.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 345 - 反转字符串中的元音字母
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }

    public static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] arr = s.toCharArray();
        while (i < j) {
            if (!list.contains(arr[i])) {
                i++;
                continue;
            }
            if (!list.contains(arr[j])) {
                j--;
                continue;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }
}
