package com.problems.mid;

import java.util.Stack;

/**
 * 1249 - 移除无效的括号
 */
public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        // "a)b(c)d"
        // "))(("
        // System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> ops = new Stack<>();
        Stack<Integer> val = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            if (s.charAt(i) == '(') {
                ops.push(i);
                continue;
            }
            if (ops.isEmpty()) {
                val.push(i);
                continue;
            }
            ops.pop();
        }

        StringBuilder sb = new StringBuilder(s);

        while (!ops.isEmpty()) {
            int i = ops.pop();
            sb.replace(i, i + 1, " ");
        }

        while (!val.isEmpty()) {
            int i = val.pop();
            sb.replace(i, i + 1, " ");
        }

        return sb.toString().replace(" ", "");
    }
}
