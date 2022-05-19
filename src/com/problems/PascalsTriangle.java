package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 杨辉三角
 * Link:     https://leetcode.cn/problems/pascals-triangle/
 * Author:   lianhai.deng
 * Date:     2022/5/19 23:46
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        generate(6);
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            if (i == 0){
                res.add(Arrays.asList(1));
                continue;
            }
            res.add(generateList(res, i));
        }
        return res;
    }

    public static List<Integer> generateList(List<List<Integer>> res, int k) {
        List<Integer> kList = new ArrayList<>(k);
        for (int i = 0; i <= k; i++) {
            if (i == 0 || i == k){
                kList.add(1);
                continue;
            }
            kList.add(res.get(k-1).get(i)+res.get(k-1).get(i-1));
        }
        return kList;
    }
}
