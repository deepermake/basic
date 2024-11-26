package com.problems.easy;

/**
 * 541 - 反转字符串II
 */
public class ReverseStr {
    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefgh", 3));

    }

    /**
     * 思路：
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int left = s.length();
        while (left > 0) {
            // 如果超过2k个字符，就反转2k个字符的前k个字符
            if (left >= k) {
                // [start, start+k]反转，[start+k+1, start+2*k]不反转
                int end = left >= 2 * k ? start + 2 * k : start + left;
                result.append(new StringBuffer(s.substring(start, start + k)).reverse()).append(s, start + k, end);
                start = start + 2 * k;
                left = left - (2 * k);
                continue;
            }
            result.append(new StringBuffer(s.substring(start)).reverse());
            break;
        }
        return result.toString();
    }
}
