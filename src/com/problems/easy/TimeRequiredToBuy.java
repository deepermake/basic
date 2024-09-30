package com.problems.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2073 - 买票需要的时间
 */
public class TimeRequiredToBuy {

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 1));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int ticket : tickets) {
            queue.add(ticket);
        }
        int res = 0;
        int len = tickets.length;

        while (k != 0 || queue.isEmpty() || queue.peek() != 1) {
            if (!queue.isEmpty()) {
                int result = queue.poll();
                result = result - 1;
                if (result > 0) {
                    queue.add(result);
                    if (k == 0) {
                        k = len - 1;
                    } else {
                        k--;
                    }

                } else {
                    len--;
                    k--;
                }
            }
            res++;
        }

        return res+1;
    }
}
