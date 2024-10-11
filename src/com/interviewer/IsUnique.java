package com.interviewer;

/**
 * 面试题 01.01 判断字符串是否唯一
 */
public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique2("leetcode"));
//        System.out.println(isUnique("abc"));
//        System.out.println(isUnique2("abc"));

    }

    /**
     * 数组解法
     *
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        boolean[] arr = new boolean[26];
        for (char c : astr.toCharArray()) {
            if (arr[c - 'a']) {
                return !arr[c - 'a'];
            }
            arr[c - 'a'] = true;
        }
        return true;
    }

    /**
     * 位运算解法
     *
     * @param str
     * @return
     */
    public static boolean isUnique2(String str) {

        int num = 0;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if ((num & (1 << index)) != 0){
                return false;
            }
            num |= (1 << index);
        }

        return true;
    }
}
