package com.problems.easy;

public class CountSegments {

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments("Hello, my name is John "));
        System.out.println(countSegments(""));
        System.out.println(countSegments("  a"));
    }

    public static int countSegments(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int res = 0;
        String[] arr = s.split(" ");
        for (String str : arr){
            if (str.isEmpty()){
                continue;
            }
            res++;
        }
        return res;
    }
}
