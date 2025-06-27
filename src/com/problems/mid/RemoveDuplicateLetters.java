package com.problems.mid;

import java.util.Stack;

/**
 * 316 - 去除重复字母
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        // System.out.println(removeDuplicateLetters("bcabc"));
        // System.out.println(removeDuplicateLetters("abcebcefedfeddefggadbc"));
        // abcdefg
    }

    public static String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        for (Character k : s.toCharArray()) {
            count[k]++;
        }

        for (Character c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;

            }
            stack.push(c);
            inStack[c] = true;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
