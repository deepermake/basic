package com.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 汇总区间
 * Link:     https://leetcode.cn/problems/summary-ranges/
 * Author:   lianhai.deng
 * Date:     2022/5/25 15:08
 */
public class SummaryRanges {

    public static void main(String[] args) {
        System.out.printf(String.valueOf(summaryRanges(new int[]{0,2})));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (right == nums.length - 1) {
                if (right != left) {
                    list.add(String.valueOf(nums[left]).concat("->").concat(String.valueOf(nums[right])));
                } else {
                    list.add(String.valueOf(nums[right]));
                }
                right++;
                continue;
            }
            if ((left == right && right == nums.length - 1) || (nums[right + 1] - nums[right] != 1 && left == right)) {
                list.add(String.valueOf(nums[right]));
                left = right + 1;
            } else if (nums[right + 1] - nums[right] != 1 && left != right) {
                list.add(String.valueOf(nums[left]).concat("->").concat(String.valueOf(nums[right])));
                left = right + 1;
            }
            right++;
        }
        return list;
    }
}
