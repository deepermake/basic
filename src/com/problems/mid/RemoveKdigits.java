package com.problems.mid;

/**
 * 402 - 移掉k位数字
 */
public class RemoveKdigits {

    public static void main(String[] args) {
//        System.out.println(removeKdigits("1432219", 3));
//        System.out.println(removeKdigits("10200", 1));
//        System.out.println(removeKdigits("10", 2));
//        System.out.println(removeKdigits("13425678232323", 6));
        // System.out.println(removeKdigits("1002020402287", 7));
        System.out.println(removeKdigits("46900921143792939364743905907950430048", 18));
    }

    /**
     * 解题私聊
     * 1、当前位置的数字最小
     * 2、位置后的数字数量不小于返回的结果
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        int t = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (num.length() - i == k - t){
                break;
            }
            if (t == k) {
                if (res.length() != 0 || arr[i] != '0') {
                    res.append(arr[i] - '0');
                }
                continue;
            }
            int temp = arr[i] - '0';
            int end = Math.min(i + k - t + 1, num.length());
            for (int j = i + 1; j < end; j++) {
                temp = Math.min(temp, arr[j] - '0');
            }
            if (temp != arr[i] - '0' || i == num.length() - 1) {
                t++;
                continue;
            }
            if (res.length() == 0 && temp == 0) {
                continue;
            }
            res.append(temp);
        }
        return res.toString().isEmpty() ? "0" : res.toString();
    }
}
