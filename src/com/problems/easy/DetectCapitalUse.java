package com.problems.easy;

import java.util.Objects;

/**
 * 520 - 检测大写字母
 */
public class DetectCapitalUse {

    public static void main(String[] args) {
//        System.out.println(detectCapitalUse("FlaG"));
//        System.out.println(detectCapitalUse("USA"));
        // System.out.println(detectCapitalUse("g"));
        System.out.println(detectCapitalUse("Ag"));
    }

    /**
     * 都是大写
     * 都不是大写
     * <p>
     * 首字母大写其余小写
     *
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        if (Objects.equals(word.toUpperCase(), word)) {
            return true;
        }

        if (Objects.equals(word.toLowerCase(), word)) {
            return true;
        }

        // 首字母大写情况
        String fromOneStr = word.substring(1);
        return word.charAt(0) - 'A' >= 0 && word.charAt(0) - 'A' <= 25 && Objects.equals(fromOneStr.toLowerCase(), fromOneStr);

    }
}
