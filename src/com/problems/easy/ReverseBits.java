package com.problems.easy;

/**
 * 面试题 05.03
 */
public class ReverseBits {

    public static void main(String[] args) {
        // System.out.println(reverseBits(1775));
        System.out.println(reverseBits(-1));
    }

    public static int reverseBits(int num) {
        int cur = 0, insert = 0, res = 1;
        for (int i = 0; i < 32; i++) {
            int t = num & (1 << i);
            if (t != 0){
                cur++;
                insert++;
            }else {
                insert = cur + 1;
                cur = 0;
            }
            res = Math.max(res, insert);
        }

        return res;
    }
}
