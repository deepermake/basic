package com.problems.mid;

import java.util.Stack;

/**
 * 394 - 字符串解码
 */
public class DecodeString {

    public static void main(String[] args) {
        // System.out.println(decodeString("3[a]2[bc]"));
        // System.out.println(decodeString("asd3[sd4[daf3[2[edf]]]ad]cf"));
        System.out.println(decodeString("asd30[sd14[daf3[2[edf]]]ad]cf"));
    }

    public static String decodeString(String s) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                ops.push(String.valueOf(c));
                continue;
            }
            if (c == ']') {
                deal(ops, vals);
                continue;
            }
            if (c < 48 || c > 57) {
                vals.push(String.valueOf(c));
                continue;
            }

            int j = i;
            String num = "";
            while (s.charAt(j) >= 48 && s.charAt(j) <= 57) {
                num = num.concat(String.valueOf(s.charAt(j)));
                j++;
            }
            vals.push(num);
            i = j - 1;
        }
        String res = "";
        while (!vals.isEmpty()) {
            res = vals.pop().concat(res);
        }
        return res;
    }

    public static void deal(Stack<String> ops, Stack<String> vals) {
        ops.pop();
        String sb = "";
        int time = 0;
        while (!vals.isEmpty()) {
            String str = vals.peek();
            if (str.charAt(0) >= 48 && str.charAt(0) <= 57) {
                time = Integer.parseInt(vals.pop());
                break;
            }
            sb = vals.pop().concat(sb);
        }
        String res = "";
        for (int i = 0; i < time; i++) {
            res = res.concat(sb);
        }
        vals.push(res);
    }
}
