package com.problems.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 2767 - 将字符串分割为最少的美丽子字符串
 */
public class MinimumBeautifulSubstrings {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1011");
        list.add("111");
        list.add("1011100111");
        list.add("0");
        for (String str : list){
            System.out.println(minimumBeautifulSubstrings(str));
        }
    }

    public static Integer res = Integer.MAX_VALUE;
    public static int minimumBeautifulSubstrings(String s) {
        res = Integer.MAX_VALUE;
        if (Objects.equals(s, "1")) {
            return 1;
        }
        if (Objects.equals(s, "0")) {
            return -1;
        }
        if (Objects.equals(s.charAt(0), '0')){
            return -1;
        }
        List<Integer> path = new ArrayList<>();
        back(s, path);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void back(String s, List<Integer> path) {
        if (!path.isEmpty() && path.get(path.size() - 1) == s.length()) {
            res = Math.min(res, path.size());
            return;
        }
        int index = path.isEmpty() ? 0 : path.get(path.size() - 1);
        for (int i = 1; i + index <= s.length(); i++) {
            if (i + index < s.length() - 1 && s.charAt(i + index) == '0') {
                continue;
            }
            String str = s.substring(index, i + index);
            if (!isMatchFive(str)) {
                continue;
            }

            path.add(i + index);
            back(s, path);
            path.remove(path.size() - 1);
        }
    }

    public static boolean isMatchFive(String str) {
        if (str.length() == 1 && Objects.equals(str, "1")) {
            return true;
        }
        int sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sum += (int) (Math.pow(2, i) * (str.charAt(str.length() - 1 - i) - '0'));
        }

        while (sum % 5 == 0){
            sum = sum / 5;
        }
        return sum == 1;

    }
}
