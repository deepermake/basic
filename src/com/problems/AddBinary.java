package com.problems;

/**
 * @description 二进制求和
 * @Date 2022/2/21 19:51
 * @Created by lianhai.deng
 */

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }

    public static String addBinary(String a, String b) {
        int i = 1, j = 1;
        int tem = 0;
        StringBuilder result = new StringBuilder();
        while (i <= a.length() || j <= b.length()) {
            int aTemp = 0, bTemp = 0;
            if (i <= a.length()){
                aTemp = Integer.parseInt(String.valueOf(a.charAt(a.length() - i)));
            }
            if (j <= b.length()){
                bTemp = Integer.parseInt(String.valueOf(b.charAt(b.length() - j)));
            }
            int re = aTemp + bTemp + tem;
            switch (re){
                case 0:
                    result.append(0);
                    tem = 0;
                    break;
                case 1:
                    result.append("1");
                    tem = 0;
                    break;
                case 2:
                    result.append("0");
                    tem = 1;
                    break;
                case 3:
                    result.append("1");
                    tem = 1;
            }
            i++;
            j++;
        }
        if (tem > 0){
            result.append("1");
        }
        return result.reverse().toString();
    }
}
