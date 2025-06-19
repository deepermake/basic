package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 93 - 复原IP地址
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        back(s, res, new ArrayList<>(), 0);
        return res;
    }

    public static void back(String s, List<String> res, List<String> path, int i) {
        if (i == s.length() && path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }

        if (i >= s.length()) {
            return;
        }

        for (int k = 1; k < 4; k++) {
            if (k != 1 && s.charAt(i) == '0') {
                continue;
            }
            String temp = s.substring(i);
            if (i + k < s.length()) {
                temp = s.substring(i, i + k);
            }
            if (Integer.parseInt(temp) > 255 || path.size() == 4) {
                return;
            }
            path.add(temp);
            i = i + k;
            back(s, res, path, i);
            i = i - k;
            path.remove(path.size() - 1);
        }
    }
}
