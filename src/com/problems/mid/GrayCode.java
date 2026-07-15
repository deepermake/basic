package com.problems.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode ob = new GrayCode();
        System.out.println(ob.grayCode(16));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int temp = 0, k = 0;
        list.add(temp);
        int len = (int) Math.pow(2, n);
        while (list.size() < len) {
            for (int i = 0; i < n; i++) {
                if (k != 0 && k == i) {
                    continue;
                }
                // 取下一个数
                int num = temp ^ (1 << i);
                if (list.contains(num) ||
                        (list.size() == len - 1 && (num & (num - 1)) != 0)) {
                    continue;
                }
                list.add(num);
                temp = num;
                k = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

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
