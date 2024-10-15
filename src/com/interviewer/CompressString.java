package com.interviewer;

/**
 * 面试题 01.06 字符串压缩
 */
public class CompressString {

    public static void main(String[] args) {
        System.out.println(compressString("aabbcc"));
        System.out.println(compressString("aab"));
        System.out.println(compressString("a"));
    }

    public static String compressString(String s) {
        if (s.isEmpty() || s.length() == 1){
            return s;
        }

        int i = 0, j = 0;
        String result = "";
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                result = result.concat(String.valueOf(s.charAt(i))).concat((j - i) + "");
                i = j;
            }
            j++;
        }
        result = result.concat(String.valueOf(s.charAt(j - 1))).concat((j - i) + "");

        return result.length() >= s.length() ? s : result;

    }
}
