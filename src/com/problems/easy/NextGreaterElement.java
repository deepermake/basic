package com.problems.easy;

public class NextGreaterElement {

    public static void main(String[] args) {
        // System.out.println(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        // System.out.println(nextGreaterElement(new int[]{4, 2}, new int[]{1, 2, 3, 4}));
        System.out.println(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] re = new int[nums1.length];
        int k = -1;
        for (int i = 0; i < nums1.length; i++) {
            re[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    k = j;
                    continue;
                }

                if (k > -1 && j > k && nums2[k] < nums2[j]) {
                    re[i] = nums2[j];
                    break;
                }
            }
            k = -1;
        }
        return re;
    }
}
