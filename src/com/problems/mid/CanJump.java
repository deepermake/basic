package com.problems.mid;

/**
 * 55 跳跃游戏
 */
public class CanJump {

    public static void main(String[] args) {
        System.out.println(canJumpByDp(new int[]{2, 3, 1, 1, 4}));
        // System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }


    /**
     * 贪心算法 解题思路 同 45 - 跳跃游戏||
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int start = nums.length - 2;
        int temp = target;
        while (target != 0) {
            if (nums[start] >= target - start) {
                temp = start;
            }

            if (start != 0) {
                start--;
                continue;
            }

            if (nums[start] < target && temp == target) {
                return false;
            }
            target = temp;
            start = temp - 1;
        }

        return true;
    }


    /**
     * 动态规划解题思路
     * <p>
     * dp[i] 表示是否可以到达i点，默认为false
     * dp[j] 表示是否可以达到j坐标，
     * <p>
     * 则 j可以到达i的表达式为 dp[i] = dp[j] && nums[j] > i - j
     *
     * @param nums
     * @return
     */
    public static boolean canJumpByDp(int[] nums) {
        int l = nums.length;
        boolean[] dp = new boolean[l];
        dp[0] = true;
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                }
            }
        }
        return dp[l - 1];
    }
}
