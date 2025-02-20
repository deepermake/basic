package com.problems.mid;

import java.util.Objects;

/**
 * 91 - 解码方法
 */
public class NumDecodings {

    public static void main(String[] args) {
        System.out.println(numDecodings("120"));
    }


    /**
     * 动态规划
     * <p>
     * " 120" dp[0] = 1 dp[1] = 1 dp[2] = 2 dp[3] = 1
     * " 202" dp[0] = 1 dp[1] = 1 dp[2] = 1 dp[3] = 1
     * dp[i] 表示，前i个字符的解码数
     * dp[i-1] 前i-1个字符的解码数
     * dp[0] = 1 空格 + 输入字符
     * dp[i] = dp[i-1]  if  0 < s[i] <= 9
     * dp[i] = dp[i-2]  if  10 <= s[i-1]+s[i] <= 26
     * dp[i] = dp[i-1] + dp[i-2]
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        if (Objects.isNull(s) || s.charAt(0) == '0') {
            return 0;
        }
        s = " " + s;
        char[] chr = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int a = chr[i] - '0';
            int b = (chr[i - 1] - '0') * 10 + a;
            boolean aFlag = a > 0 && a <= 9;
            boolean bFlag = b >= 10 && b <= 26;
            if (aFlag && bFlag) {
                dp[i] = dp[i-1] + dp[i-2];
                continue;
            }
            if (aFlag) {
                dp[i] = dp[i-1];
                continue;
            }

            if (bFlag) {
                dp[i] = dp[i-2];
            }
        }

        return dp[s.length()-1];
    }
}
