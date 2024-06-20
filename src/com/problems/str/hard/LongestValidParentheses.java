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
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            // 为“(”时将下表入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            // pop栈内元素
            stack.pop();
            // 如果此时为空栈，更新栈底元素
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            // 计算最值当前坐标-栈顶坐标
            max = Math.max(max, i - stack.peek());
        }
        return max;
    }
}
