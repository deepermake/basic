package com.problems.mid;

import java.util.Arrays;

/**
 * 435 - 无重叠区间
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        // System.out.println(eraseOverlapIntervals(new int[][]{{1, 4}, {2, 3}, {5, 8}, {4, 6}, {0, 1}, {9, 11}}));
        // System.out.println(eraseOverlapIntervals(new int[][]{{0, 1}, {1, 5}, {1, 4}, {1, 3}, {3, 6}, {7, 8}, {8, 10}, {9, 12}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{0, 1}, {2, 9}, {3, 6}, {8, 9}, {4, 7}, {5, 6}, {4, 8}, {7, 9}, {1, 10}}));
    }

    /**
     * [[1,4],[2,3],[5,8],[4,6],[0,1],[9,11]]
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int re = 0;
        int i = 0, j = i + 1;
        while (i < intervals.length && j < intervals.length) {
            // 判断是否有交集
            if (intervals[i][0] <= intervals[j][0] && intervals[j][0] < intervals[i][1]) {
                if (intervals[i][0] <= intervals[j][1] && intervals[j][1] <= intervals[i][1]) {
                    i = j;
                }
                re++;
                j++;
                continue;
            }
            i = j;
            j++;

        }
        return re;
    }
}
