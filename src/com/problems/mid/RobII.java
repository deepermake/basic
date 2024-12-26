package com.problems.mid;

/**
 * 213 打家劫舍II
 */
public class RobII {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{8, 4, 8, 5, 9, 6, 5, 4, 4, 10}));
        System.out.println(rob(new int[]{2, 1, 2, 6, 1, 8, 10, 10}));
    }

    public static int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) return nums[0];
        if (l == 2) return Math.max(nums[0], nums[1]);
        if (l == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int[] dp1 = new int[l - 1];
        dp1[0] = nums[0];
        dp1[1] = nums[1];
        dp1[2] = nums[0] + nums[2];
        for (int i = 3; i < l - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + nums[i];
        }

        int[] dp2 = new int[l - 1];
        dp2[0] = nums[1];
        dp2[1] = nums[2];
        dp2[2] = nums[1] + nums[3];
        for (int i = 3; i < l - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2], dp2[i - 3]) + nums[i + 1];
        }

        return Math.max(Math.max(Math.max(dp1[l-2], dp1[l-3]), dp2[l-2]),dp2[l-3]);


    }
}
