package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 131 - 分割回文串
 */
public class Partition {

    public static void main(String[] args) {
        partition("aabaa");
    }

    public static List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                if (i == 0) {
                    dp[j][j] = true;
                    continue;
                }
                if (i == 1) {
                    dp[j][j + 1] = s.charAt(j) == s.charAt(j + 1);
                    continue;
                }
                dp[j][i + j] = dp[j + 1][i + j - 1] && s.charAt(j) == s.charAt(i + j);
            }
        }
        List<List<String>> res = new ArrayList<>();
        back(s, dp, res, new ArrayList<>(), 0);
        return res;
    }


    public static void back(String s, boolean[][] dp, List<List<String>> res, List<String> path, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                path.add(s.substring(start, i  + 1));
                back(s, dp, res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
