package com.problems.easy.array;


/**
 * 495 - 提莫攻击
 */
public class FindPoisonedDuration {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
    }


    /**
     * 解题思路
     * timeSeries[i]时刻，进行攻击，持续timeSeries[i], timeSeries[i]+duration秒中毒状态
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int temp = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (duration + timeSeries[i] >= timeSeries[i + 1]) {
                temp += timeSeries[i + 1] - timeSeries[i];
                continue;
            }
            temp += duration;
        }

        return temp + duration;
    }
}
