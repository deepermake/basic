package com.problems.mid;

import java.util.Arrays;

/**
 * 6 - Z字形变换
 */
public class ZStringConvert {

    public static void main(String[] args) {
        // System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("AB", 1));
    }

    /**
     * 0
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        String[] str = new String[numRows];
        Arrays.fill(str, "");
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = start;
            if (start >= numRows) {
                index = 2 * numRows - 2 - start;
            }
            str[index] = str[index].concat(String.valueOf(s.charAt(i)));
            start++;
            if (start == 2 * numRows - 2) {
                start = 0;
            }
        }

        // PAHNAPLSIIGYIR

        String res = "";
        for (int i = 0; i < numRows; i++) {
            res = res.concat(str[i]);
        }
        return res;
    }
}
