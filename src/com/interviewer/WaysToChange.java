package com.interviewer;

/**
 * 面试题 08.11 硬币
 */
public class WaysToChange {

    public static void main(String[] args) {
        //332576607
        System.out.println(waysToChange(1000000));
        // 30
        System.out.println(waysToChange(30));
        System.out.println(waysToChange(10));
    }

    /**
     * 25分、10分、5分和1分
     * <p>
     * 5x + 10y + 25z + k = n;
     * 求x,y,z的可能出现的组合
     * <p>
     * 0  1
     * 1  1
     * 2  1
     * 3  1
     * 4  1
     * 5  2
     * 10 4
     *
     * @param n
     * @return
     */
    public static int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{5, 10, 25};
        for (int i = 0; i <= n; i++){
            dp[i] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                    if (dp[j] - 1000000007 > 0){
                        dp[j] = dp[j] % 1000000007;
                    }
                }
            }
        }
        return dp[n];

    }
}
