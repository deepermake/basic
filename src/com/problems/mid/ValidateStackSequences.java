package com.problems.mid;

import java.util.Stack;

/**
 * 946 - 验证栈序列
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0, l = pushed.length;
        while (i < l) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.isEmpty();
    }
}
