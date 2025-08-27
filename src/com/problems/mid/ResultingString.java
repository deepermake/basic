package com.problems.mid;

/**
 * 3561 - 移除相邻字符
 */
public class ResultingString {
    public static void main(String[] args) {
        System.out.println(resultingString("adcb"));
    }

    public static String resultingString(String s) {
        StringBuilder re = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (re.length() == 0) {
                re.append(c);
                continue;
            }

            int i = Math.abs(c - re.charAt(re.length() - 1));
            boolean flag = i == 1 || i == 25;
            if (flag) {
                re.deleteCharAt(re.length() - 1);
                continue;
            }
            re.append(c);
        }
        return re.toString();

    }
}
