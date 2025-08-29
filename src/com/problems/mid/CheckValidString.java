package com.problems.mid;

import java.util.Stack;

/**
 * 678 - 有效的括号字符串
 */
public class CheckValidString {

    public static void main(String[] args) {
        // System.out.println(checkValidString("(*))"));
        // System.out.println(checkValidString("(***(("));
        // System.out.println(checkValidString("()()((()))"));
        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> ops = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ops.push(i);
                continue;
            }
            if (s.charAt(i) == '*') {
                star.push(i);
                continue;
            }
            if (ops.isEmpty()) {
                ops.push(i);
                continue;
            }
            if (s.charAt(ops.peek()) == '(') {
                ops.pop();
                continue;
            }
            ops.push(i);
        }

        while (!ops.isEmpty() && !star.isEmpty()) {
            if (s.charAt(ops.peek()) == '(') {
                // ( *
                if (ops.peek() < star.peek()) {
                    ops.pop();
                }
                star.pop();
                continue;
            }

            //  * )
            if (ops.peek() > star.peek()) {
                ops.pop();
            }
            star.pop();
        }

        return ops.isEmpty();
    }
}
