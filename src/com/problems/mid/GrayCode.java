package com.problems.mid;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode ob = new GrayCode();
        System.out.println(ob.grayCode(16));
    }

    List<Integer> list = new ArrayList<>();
    boolean found = false;

    public List<Integer> grayCode(int n) {
        list.add(0);
        backtracking(n, 0);
        return list;
    }

    public void backtracking(int n, int cur) {
        if (found) {
            return;
        }
        // 终止条件
        if (list.size() == (1 << n)
                && diff_one_bit(0, list.get(list.size() - 1))) {
            found = true;
            return;
        }

        for (int i = 0; i < (1 << n); i++) {
            int num = fit_bit(cur, i);
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            backtracking(n, num);
            if (found) {
                return;
            }
            list.remove(list.size() - 1);
        }
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

    /**
     * 是否只有1位不同
     *
     * @param a
     * @param b
     * @return
     */
    public boolean diff_one_bit(int a, int b) {
        int xor = a ^ b;
        return xor != 0 && (xor & (xor - 1)) == 0;
    }
}
