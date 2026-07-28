package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode ob = new GrayCode();
        System.out.println(ob.grayCode(1));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int k = 0; k < n; k++) {
            int j = list.size();
            for (int i = j - 1; i >= 0; i--) {
                list.add(list.get(i) | (1 << k));
            }

        }
        return list;
    }

    /**
     * 翻转第i位得到的值
     *
     * @param num
     * @param n
     * @return
     */
    public Integer fit_bit(int num, int n) {
        return num ^ (1 << n);
    }
}
