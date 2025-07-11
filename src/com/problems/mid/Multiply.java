package com.problems.mid;

import java.util.Objects;

/**
 * 43 - 字符串相乘
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {

        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }

        int[] arr = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int valI = num1.charAt(num1.length() - 1 - i) - 48;
                int valJ = num2.charAt(num2.length() - 1 - j) - 48;
                int k = (valI * valJ) / 10;
                int m = (valI * valJ) % 10;
                arr[i + j] = arr[i + j] + m;
                if (arr[i + j] >= 10) {
                    arr[i + j] = arr[i + j] % 10;
                    k = k + 1;
                }
                arr[i + j + 1] = arr[i + j + 1] + k;
                if (arr[i + j + 1] >= 10) {
                    arr[i + j + 1] = arr[i + j + 1] % 10;
                    arr[i + j + 2] = arr[i + j + 2] + 1;
                }
            }

        }
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1 && arr[i] == 0) {
                continue;
            }
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}
