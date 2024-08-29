package com.problems.str.easy;

/**
 * 415 - 字符串相加
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
        System.out.println(addStrings("584", "18"));
    }

    public static String addStrings(String num1, String num2) {

        int temp = 0;
        int i = 1;
        StringBuilder result = new StringBuilder();
        while (i <= num1.length() || i <= num2.length()) {

            int number1 = 0, number2 = 0;
            if (i <= num1.length()) {
                number1 = num1.charAt(num1.length() - i) - 48;
            }
            if (i <= num2.length()) {
                number2 = num2.charAt(num2.length() - i) - 48;
            }

            result.insert(0, (number1 + number2 + temp) % 10);
            temp = (number1 + number2 + temp) / 10;

            i++;
        }

        if (temp == 1){
            result.insert(0, temp);
        }

        return result.toString();
    }
}
