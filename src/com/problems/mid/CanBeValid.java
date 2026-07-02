package com.problems.mid;

import java.util.Stack;

public class CanBeValid {

    public static void main(String[] args) {
        System.out.println(canBeValid("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001"));

        // 1011001001010010100010001001
        // (((()()))()((()))))()((()(()
        // System.out.println(canBeValid("(((())(((())", "111111010111"));
        // 1 1010 1
        // ( (((( )
    }

    public static boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }



        return false;
    }


}
