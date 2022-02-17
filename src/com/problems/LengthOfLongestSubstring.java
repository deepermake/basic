package com.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 无重复字符的最长子串
 * @Date 2022/2/17 16:27
 * @Created by lianhai.deng
 */

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        return ans;
    }
}
