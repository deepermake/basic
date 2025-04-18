package com.problems.mid;

import java.util.Arrays;
import java.util.Objects;

/**
 * 179 - 最大数
 */
public class LargestNumber {

    public static void main(String[] args) {
//        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
//        System.out.println(largestNumber(new int[]{24, 3, 58, 7, 2,6}));
        // System.out.println(largestNumber(new int[]{700000000, 500000000}));
//        System.out.println(largestNumber(new int[]{1, 0, 0}));
//        System.out.println(largestNumber(new int[]{0, 0}));
//        System.out.println(largestNumber(new int[]{1000000000,1000000000}));
        System.out.println(largestNumber(new int[]{111111121, 11111112}));
    }

    public static String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return "" + nums[0];
        }
        Arrays.sort(nums);
        String re = "";
        int i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            int k = getNum(i, j, nums);
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
            if (j == nums.length - 1) {
                if (re.isEmpty() && nums[i] == 0) {
                    return "" + nums[i];
                }
                re = re.concat("" + nums[i]);
                i++;
                j = i + 1;
                continue;
            }
            j++;
        }
        return re.concat("" + nums[nums.length - 1]);
    }

    /**
     * 找更大的数
     *
     * @return
     */
    public static int getNum(int i, int j, int[] nums) {
        String a = nums[i] + "" + nums[j];
        String b = nums[j] + "" + nums[i];
        if (Objects.equals(a, b)) {
            return i;
        }
        for (int k = 0; k < a.length(); k++) {
            if (a.charAt(k) == b.charAt(k)) {
                continue;
            }
            return a.charAt(k) > b.charAt(k) ? i : j;
        }
        return j;
    }
}
