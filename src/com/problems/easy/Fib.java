package com.problems.easy;

public class Fib {

    public static void main(String[] args) {
        System.out.println(String.valueOf(fib(0)));
        System.out.println(String.valueOf(fib(1)));
        System.out.println(String.valueOf(fib(2)));
        System.out.println(String.valueOf(fib(3)));
        System.out.println(String.valueOf(fib(4)));
        System.out.println(String.valueOf(fib(5)));
        System.out.println(String.valueOf(fib(6)));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int k = 0, t = 1, result = 1;
        for (int i = 2; i <= n; i++) {
            result = t + k;
            k = t;
            t = result;
        }
        return result;
    }
}
