package com.problems.mid;

import java.util.Objects;
import java.util.Stack;

/**
 * 71 - 简化路径
 */
public class SimplifyPath {

    public static void main(String[] args) {
        // System.out.println(simplifyPath("/home/a/foo/a//../"));
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < path.length() && i >= 0) {
            int j = path.indexOf("/", i + 1);
            String str = "";
            if (j < 0) {
                str = path.substring(i + 1);
            } else {
                str = path.substring(i + 1, j);
            }
            boolean isNotDeal = Objects.equals(str, ".") || Objects.equals(str, "/") || Objects.equals(str, "");
            if (isNotDeal) {
                i = j;
                continue;
            }
            if (Objects.equals(str, "..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                i = j;
                continue;
            }
            stack.push(str);
            i = j;
        }
        if (stack.isEmpty()) {
            return "/";
        }

        String str = "";
        while (!stack.isEmpty()) {
            str = "/".concat(stack.pop()).concat(str);
        }
        return str;
    }
}
