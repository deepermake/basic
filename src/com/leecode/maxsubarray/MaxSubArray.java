package com.leecode.maxsubarray;

/**
 *
 * @description 最大子序和
 * @author 邓联海
 * @date 2021/6/5 16:52
 */
public class MaxSubArray {

    public static void main(String[] args){
        int[] nums = {-1,0,-2};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int len = nums.length;
        for (int i = 0; i< len;i++){
            int sum = nums[i];
            for (int j = i+1; j <len;j++){
                sum = nums[j];
                if (sum > max){
                    max = sum;
                }else {
                    sum += nums[j];
                }
            }
            if (i == len -1 && sum >= max){
                max = sum;
            }
        }
        return max;
    }
}
