package com.problems;

/**
 * @description 二进制求和
 * @Date 2022/2/21 19:51
 * @Created by lianhai.deng
 */

public class AddBinary {
    public static void main(String[] args) {
        addBinary("1010", "1011");
    }

    public static String addBinary(String a, String b) {
        int i = 1, j = 1;
        int tem = 0;
        String result = "";
        while (i < a.length() || j < b.length()) {
            int aTemp = Integer.parseInt(String.valueOf(a.charAt(a.length() - i)));
            int bTemp = Integer.parseInt(String.valueOf(b.charAt(b.length() - j)));
            if (aTemp + bTemp + tem >= 2){
                result += "0";
                tem = 1;
            }else {
                tem = 0;
                result += "1";
            }
            i++;
            j++;
        }
        return "";
    }
}
