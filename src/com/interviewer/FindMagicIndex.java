package com.interviewer;

/**
 * 面试题 08.03 魔术索引
 */
public class FindMagicIndex {
    public static void main(String[] args) {
        findMagicIndex(new int[]{1, 2, 2, 4, 5});
        findMagicIndexBinarySearch(new int[]{1, 2, 2, 4, 5});
    }

    /**
     * 常规做法
     *
     * @param nums
     * @return
     */
    public static int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int res = -1;

    /**
     * 2分查找做法
     * 什么样的情况下可以应用二分查找，数组必须是有序的
     *
     * @param nums
     * @return
     */
    public static int findMagicIndexBinarySearch(int[] nums) {
        if (nums[0] == 0) {
            return 0;
        }
        binarySearch(nums, 0, nums.length - 1);
        return res;

    }

    public static void binarySearch(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == mid) {
            res = mid;
            binarySearch(nums, low, mid - 1);
        } else {
            binarySearch(nums, low, mid - 1);
            if (res == -1) {
                binarySearch(nums, mid + 1, high);
            }

        }

    }

}
