package com.problems.str.easy;

/**
 * Excel 表列名称
 */
public class ExcelTitleToNumber {

    public static void main(String[] args) {
        System.out.println('Z'-'A' + 1);
        // 1
        System.out.println(titleToNumber("A"));
        // 28
        System.out.println(titleToNumber("AB"));
        // 701
        System.out.println(titleToNumber("ZY"));
        // 701
        System.out.println(titleToNumber("AAE"));
        // 2147483647
        System.out.println(titleToNumber("FXSHRXW")); //
    }

    public static int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 1) {
            return columnTitle.charAt(0) - 'A' + 1;
        }
        // 结果
        int result = columnTitle.charAt(0) - 'A' + 1;
        int index = 1;

        while (index < columnTitle.length()) {
            char value = columnTitle.charAt(index);
            result = result * 26 + (value - 'A' + 1);
            index ++;
        }
        return result;
    }
}
