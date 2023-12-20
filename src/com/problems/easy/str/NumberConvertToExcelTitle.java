package com.problems.easy.str;

import java.util.HashMap;
import java.util.Map;

public class NumberConvertToExcelTitle {

    public static void main(String[] args) {
        //  1 - 26       A - Z      26 * 0 + (1 ~ 26)
        // 27 - 52  A + (A - Z)     26 * 1 + (1 ~ 26)
        // 53 - 78  B + (A - Z)     26 * 2 + (1 ~ 26)

        //System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(701));
        //System.out.println(convertToTitle(2147483647));
        //System.out.println(convertToTitle(265677));
    }


    public static String convertToTitle(int columnNumber) {
        String[] str = new String[]{
                "Z",
                "A", "B", "C", "D",
                "E", "F", "G", "H",
                "I", "J", "K", "L",
                "M", "N", "O", "P",
                "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y"};
        if (columnNumber < 25) {
            return str[columnNumber];
        }
        if (columnNumber == 25) {
            return "Z";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 25) {
            int left = columnNumber % 26;
            stringBuilder.append(str[left]);
            columnNumber = (columnNumber / 26);
            if (left == 0) {
                columnNumber = columnNumber - 1;
            }
        }
        if (columnNumber != 0) {
            stringBuilder.append(str[columnNumber]);
        }
        return stringBuilder.reverse().toString();
    }
}
