package com.problems.mid;

/**
 * 134 - 加油站
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, index = -1, temp = 0;
        boolean flag = true;

        while (i < gas.length && i != index) {
            if (gas[i] + temp < cost[i]) {
                if (i < index) {
                    return -1;
                }
                index = -1;
                flag = true;
                temp = 0;
                i++;
                continue;
            }

            temp = temp + gas[i] - cost[i];
            if (flag) {
                index = i;
                flag = false;
            }
            i++;
            if (i == gas.length) {
                i = 0;
            }
        }
        return index;
    }
}
