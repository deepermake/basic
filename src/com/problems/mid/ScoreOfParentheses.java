package com.problems.mid;

import java.util.Objects;
import java.util.Stack;

/**
 * 856 - 括号的分数
 */
public class ScoreOfParentheses {

    public static void main(String[] args) {
        // System.out.println(scoreOfParentheses("(()(()))"));
//        "()"
//        "(())"
//        "()()"
//        "(()()((()())))"
        // System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        //System.out.println(scoreOfParentheses("()()"));
    }

    public static int scoreOfParentheses(String s) {
        Stack<String> ops = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ops.push(String.valueOf(c));
                continue;
            }

            int res = 1;
            String temp = ops.pop();
            if (ops.isEmpty()) {
                ops.push(String.valueOf(res));
                continue;
            }

            if (!Objects.equals(temp, "(")) {
                res = Integer.parseInt(temp) * 2;
                ops.pop();
                if (!ops.isEmpty() && !Objects.equals(ops.peek(), "(")) {
                    res = res + Integer.parseInt(ops.pop());
                }
                ops.push(String.valueOf(res));
                continue;
            }
            String next = ops.peek();
            if (Objects.equals(next, "(")) {
                ops.push(String.valueOf(res));
                continue;
            }

            res = res + Integer.parseInt(ops.pop());
            ops.push(String.valueOf(res));
        }
        return Integer.parseInt(ops.pop());

    }
}
