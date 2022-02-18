package com.problems;

import java.util.Objects;

/**
 * @description 最后一个单词的长度
 * @Date 2022/2/18 17:10
 * @Created by lianhai.deng
 */

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("f"));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        int lastLen = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (!Objects.equals(s.substring(i - 1, i), " ")) {
                len++;
                lastLen = len;
            } else {
                len = 0;
            }
        }
        return lastLen;
    }
}
