package com.leecode.validparentheses;

import java.util.Stack;

/**
 * @author 邓联海
 * @description
 * @date 2021/5/28 14:26
 */
public class ValidParenthese {

    public static void main(String[] args) {
        String s = "([]){";
        System.out.println("it is a valid parenthese, " + isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        for (Character c:s.toCharArray()){
            if (c == '(' || c== '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if (stack.empty()){
                return false;
            }
            if (c == ')' && stack.lastElement() != '('){ return false;}
            if (c == ']' && stack.lastElement() != '['){ return false;}
            if (c == '}' && stack.lastElement() != '{'){ return false;}
            stack.pop();
        }
        return stack.empty();
    }

}
