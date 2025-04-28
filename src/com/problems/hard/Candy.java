package com.problems.hard;

import java.util.Arrays;

/**
 * 135 - 分发糖果
 */
public class Candy {

    public static void main(String[] args) {
        // System.out.println(candy(new int[]{0, 3, 2, 2, 1, 0}));
        System.out.println(candy(new int[]{1, 3, 3, 2, 2, 4, 5, 3, 2, 4, 5, 6, 3, 4, 5, 7}));
        //                                 1, 2, 1, 1, 1, 2, 3, 1, 1, 2, 3, 4, 1, 2, 3, 4
        //                                 1, 2, 3, 2, 1, 2, 3, 2, 1, 2, 3, 4, 1, 2, 3, 4
    }

    /**
     * 考虑递减性，如果递减
     * 关注元素的连续递增性和递减性
     * <p>
     * 主要需要考量递减性，递增性
     * 区间性
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int l = ratings.length, result = 0;
        int[] res = new int[l];
        Arrays.fill(res, 1);
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = l - 1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1]) {
                if (res[i] > res[i - 1]) {
                    continue;
                }
                res[i - 1] = res[i] + 1;
                continue;
            }
            if (ratings[i] == ratings[i - 1]) {
                continue;
            }

            if (res[i] < res[i - 1]) {
                continue;
            }
            res[i - 1] = res[i] + 1;
        }

        for (int i : res) {
            result += i;
        }


        return result;
    }
}
