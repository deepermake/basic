package com.problems.easy;

/**
 * 806 写字符串需要的行数
 */
public class NumberOfLines {

    public static void main(String[] args) {
        // numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz");
        numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa");
        // numberOfLines(new int[]{7, 5, 4, 7, 10, 7, 9, 4, 8, 9, 6, 5, 4, 2, 3, 10, 9, 9, 3, 7, 5, 2, 9, 4, 8, 9},
        // "zlrovckbgjqofmdzqetflraziyvkvcxzahzuuveypqxmjbwrjvmpdxjuhqyktuwjvmbeswxuznumazgxvitdrzxmqzhaaudztgie");
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int j = 1, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = widths[s.charAt(i) - 'a'];
            if (sum + tmp > 100) {
                sum = tmp;
                j++;
                continue;
            }
            sum += tmp;
        }
        return new int[]{j, sum};
    }
}
