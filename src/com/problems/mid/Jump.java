package com.problems.mid;

/**
 * 45 - 跳跃游戏||
 */
public class Jump {

    public static void main(String[] args) {
        System.out.println(jump2(new int[]{2, 2, 5, 6, 7, 1, 4, 5, 8}));
        System.out.println(jump2(new int[]{2, 3, 1, 1, 4}));
    }


    /**
     * 解题思路
     * 已知条件：
     * 1、数组长度 n
     * 2、每个坐标可以跳跃到下一个坐标的区间
     * 3、有一个问题，以{2，3，1，1，4}举例，
     * 坐标[0],可以跳跃到[1]、[2] 这里有两种可能
     * 跳到[1]后，可以跳跃到[2]、[3]、[4]
     * 两个坐标之间具有关联性[1]坐标，需要[0]跳跃过来
     * 但是[2]坐标，可以从[0]直接跳跃，又可以从[1]跳跃
     * 所以越往后的坐标，和前面的坐标关联性就越多，坐标之间具有关联性，
     * 换一种思路，
     * 坐标之间的关联性，dp[i][j]表示，是否可以从[i]跳跃到[j]
     * dp[i][j] = j - i >= arr[i]
     * 这种关系比较容易得到，但是我需要得到最小跳跃数需要如何做？
     *
     * <p>
     * 求解：
     * 到达n-1坐标的最少跳跃数
     * <p>
     * 动态规划
     * dp[i][j] 表示从i 跳到 j的最小跳跃数 dp[i][j] = dp[0][i-1] + 1
     *
     * @param nums
     * @return
     */
//    public static int jump(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = 1; i <= nums[0]; i++) {
//            dp[0][i] = 1;
//        }
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            for (int j = i; j < nums.length; j++) {
//
//                if (i == j) {
//
//                }
//            }
//
//        }
//
//        return 0;
//    }

    /**
     * dp[i][j] 表示从i到j的最小跳跃数
     *
     * @param nums
     * @return Memory over
     */
    public static int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int[][] dp = new int[nums.length - 1][nums.length];

        for (int i = 0; i < nums.length - 1; i++) {

            int lastSmallStep = getLastSmallStep(i, dp);

            for (int j = i; j < nums.length; j++) {

                if (i != 0 && lastSmallStep == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == j) {
                    dp[i][j] = lastSmallStep;
                    continue;
                }

                if (j - i <= nums[i]) {
                    dp[i][j] = lastSmallStep + 1;
                    continue;
                }
                break;
            }

        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (dp[i][nums.length - 1] == 0) {
                continue;
            }
            result = Math.min(result, dp[i][nums.length - 1]);
        }
        return result;
    }

    /**
     * 获取到达某一坐标的最小跳跃数
     *
     * @param i
     * @return
     */
    public static int getLastSmallStep(int i, int[][] dp) {
        int result = Integer.MAX_VALUE;
        if (i == 0) {
            return 0;
        }

        for (int j = 0; j < i; j++) {
            if (dp[j][i] == 0) {
                continue;
            }
            result = Math.min(dp[j][i], result);
        }
        return result;
    }


    /**
     * 贪心算法
     *
     * 从结果出发，最后一个坐标反向向前跳跃
     * 每一次尽量跳的远，直到到达坐标为0的位置
     * 从len - 2的位置，开始比对，直到最后一个可以跳跃到len - 1的坐标len - x
     * 从len - x - 1的位置，开始比对，直到最后一个可以跳跃到len - x的坐标为len - x'
     * 直到len - x' = 0 结束
     *
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int target = nums.length - 1;
        int start = nums.length - 2;
        int temp = 0;
        int time = 0;
        while (target != 0) {
            // 坐标start可以跳跃到target
            if (nums[start] >= target - start) {
                temp = start;
            }

            // 坐标start不能跳跃到target
            if (start != 0) {
                start--;
                continue;
            }
            target = temp;
            start = temp - 1;
            time++;

        }
        return time;


    }
}
