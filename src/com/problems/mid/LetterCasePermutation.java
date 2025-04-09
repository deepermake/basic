package com.problems.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 784 字母大小写全排列
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        letterCasePermutation("a1b2");
        // letterCasePermutation("3z4");
    }

    /**
     * @param s
     * @return
     */
    private static String path = "";

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        back(s, res, path, 0);
        return res;
    }

    public static void back(String s, List<String> res, String path, int index) {
        if (Objects.equals(s.length(), path.length()) && !res.contains(path)) {
            res.add(path);
        }
        for (int i = index; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                path = path.concat(c.toString());
                continue;
            }
            String[] visit = new String[]{c.toString().toLowerCase(), c.toString().toUpperCase()};
            for (int j = 0; j < 2; j++) {
                path = path.concat(visit[j]);
                back(s, res, path, i + 1);
                path = path.substring(0, path.length() - 1);
            }
        }


        if (Objects.equals(s.length(), path.length()) && !res.contains(path)) {
            res.add(path);
        }
    }



}
