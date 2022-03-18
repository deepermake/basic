package com.problems;

import java.util.Objects;

/**
 * @description 实现 strStr()
 *              https://leetcode-cn.com/problems/implement-strstr/
 * @Date 2022/3/18 16:30
 * @Created by lianhai.deng
 */

public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("abc", "c"));
    }

    public static int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if (needleLen == 0 || Objects.equals(haystack, needle)) {
            return 0;
        }
        if (haystackLen == 0 || needleLen > haystackLen) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (!Objects.equals(haystack.charAt(i), needle.charAt(0))) {
                continue;
            }
            if (needleLen > haystackLen - i) {
                return -1;
            }
            String matchHayStack = haystack.substring(i, needleLen + i);
            if (Objects.equals(matchHayStack, needle)) {
                return i;
            }
        }
        return -1;
    }


}
