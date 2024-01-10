package com.problems.str.hard;

import java.util.Stack;

/**
 * Description: 32 最长有效括号
 * Link: https://leetcode-cn.com/problems/longest-valid-parentheses/
 * Author:   lianhai.deng
 * Date:     2024/1/10 22:34
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        // (()))
        System.out.println(longestValidParentheses("((())())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int count = 0;
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                i++;
                continue;
            }
            if (s.charAt(i) == ')' && stack.peek() == '(') {
                count += 2;
                stack.pop();
            } else if (s.charAt(i) == ')' && stack.peek() == ')'){
                stack.push(s.charAt(i));
                count = 0;
            }

            max = Math.max(count, max);

            i++;
        }
        return max;
    }
}
